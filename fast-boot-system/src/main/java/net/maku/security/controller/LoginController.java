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
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("login")
    public Result login(String username, String password, HttpSession session) {
        //查看用户是否存在
        System.out.println(PasswordEncoder.encode(password));
        SysUserEntity sysUserEntity = sysUserService.CheckUser(username);

        //判断用户是否存在
        if(sysUserEntity==null){
            //不存在
            return Result.error("用户不存在");
        }

        //检查密码
        Boolean matches = PasswordEncoder.matches(sysUserEntity.getPassword(), password);
        if(!matches){
            return Result.error("密码错误");
        }
        //存在
        //随机生成token，作为登录令牌
        String token = UUID.randomUUID().toString();

        //SysUserEntity对象转换为Hash存储
        System.out.println(sysUserEntity);
        Map<String, Object> map = BeanUtil.beanToMap(sysUserEntity,new HashMap<>(), CopyOptions.create()
                .setIgnoreNullValue(true)
                .setFieldValueEditor((fieldName,fieldValue)->{
                    if (fieldValue == null){
                        fieldValue = "0";
                    }else {
                        fieldValue = fieldValue + "";
                    }
                    return fieldValue;
                }));
        //4.3存储
        String tokenKey = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey,map);
        stringRedisTemplate.expire(tokenKey, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        return Result.ok(token + "-" + sysUserEntity.getRoleId());
    }

    //用户登录
    @GetMapping("logout")
    public Result logout(String token) {
        String tokenKey = LOGIN_USER_KEY + token;
        stringRedisTemplate.delete(tokenKey);
        return Result.ok("登出成功");
    }
}
