package net.maku.security.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import net.maku.framework.common.utils.RedisConstants;
import net.maku.security.service.SysUserService;
import net.maku.security.entity.SysUserEntity;

import net.maku.security.utils.UserHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@ControllerAdvice(annotations = {RestController.class, Controller.class})
@Component
public class RefreshInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(RefreshInterceptor.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SysUserService sysUserService;

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

        //构建用户认证结果，存入SecurityContext，以便Security进行授权
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                // principal: 主要信息; credentials: 证书; authorities: 权限;
                user, user.getPassword(), sysUserService.getAuthorities(user.getId()));
        SecurityContextHolder.setContext(new SecurityContextImpl(authentication));

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
