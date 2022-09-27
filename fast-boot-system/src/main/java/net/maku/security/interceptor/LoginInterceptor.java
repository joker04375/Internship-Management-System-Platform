package net.maku.security.interceptor;

import net.maku.security.entity.SysUserEntity;
import net.maku.security.service.SysUserService;
import net.maku.security.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SysUserEntity user = UserHolder.getUser();
        if(UserHolder.getUser()==null){
            response.setStatus(401);
            return false;
        }
        //构建用户认证结果，存入SecurityContext，以便Security进行授权
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                // principal: 主要信息; credentials: 证书; authorities: 权限;
                user, user.getPassword(), sysUserService.getAuthorities(user.getId()));
        SecurityContextHolder.setContext(new SecurityContextImpl(authentication));

        //放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
