package net.maku.security.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import net.maku.framework.common.utils.RedisConstants;
import net.maku.system.entity.SysUserEntity;
import net.maku.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RefreshInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public RefreshInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate=stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求头中的token
        String token = request.getHeader("authorization");
        if(StrUtil.isBlank(token)){
//            response.setStatus(401);
            return true;
        }
        //2.基于token获取redis中的用户
        String tokenkey = RedisConstants.LOGIN_USER_KEY+token;
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(tokenkey);
        //3.判断用户是否存在
        if(userMap.isEmpty()){
            return true;
        }
        //存在，保存用户到ThreadLocal
        SysUserEntity user = BeanUtil.fillBeanWithMap(userMap, new SysUserEntity(), false);
        UserHolder.saveUser(user);

        //4.设置token 刷新有效期
        stringRedisTemplate.expire(tokenkey, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        //放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
