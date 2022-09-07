package net.maku.security.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PasswordEncoder;
import net.maku.framework.common.utils.RedisConstants;
import net.maku.framework.common.utils.Result;
import net.maku.security.service.SysUserService;
import net.maku.system.entity.SysUserEntity;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static net.maku.framework.common.utils.RedisConstants.LOGIN_USER_KEY;

@RestController
@RequestMapping
@AllArgsConstructor
public class LoginController {
    private StringRedisTemplate stringRedisTemplate;

    private SysUserService sysUserService;

    //用户登录
    @RequestMapping("login")
    public Result login(String username, String password, HttpSession session) {
        //查看用户是否存在
        SysUserEntity sysUserEntity = sysUserService.CheckUser(username, PasswordEncoder.encode(password));

        //判断用户是否存在
        if(sysUserEntity==null){
            //不存在
            return Result.error("用户不存在");
        }
        //存在
        //随机生成token，作为登录令牌
        String token = UUID.randomUUID().toString();

        //SysUserEntity对象转换为Hash存储
        Map<String, Object> map = BeanUtil.beanToMap(sysUserEntity,new HashMap<>(), CopyOptions.create()
                .setIgnoreNullValue(true)
                .setFieldValueEditor((fieldName,fieldValue)->fieldValue.toString()));

        //4.3存储
        String tokenKey=LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey,map);
        stringRedisTemplate.expire(tokenKey, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        return Result.ok(token);
    }
}
