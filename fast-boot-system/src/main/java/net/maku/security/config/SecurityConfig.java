package net.maku.security.config;


import cn.hutool.json.JSONUtil;
import net.maku.framework.common.utils.Result;
import net.maku.security.constant.Authority;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //忽略处理静态资源
//        web.ignoring().antMatchers("/resources/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权
        http.authorizeRequests()
                .antMatchers(
                    "/sys/stu/**"
                )
                .hasAnyAuthority(
                        Authority.AUTHORITY_STUDENT
                )
                .antMatchers(
                        "/sys/orgs/**"
                )
                .hasAnyAuthority(
                        Authority.AUTHORITY_ENTERPRISE
                )
                .antMatchers(
                        "/sys/college/**"
                )
                .hasAnyAuthority(
                        Authority.AUTHORITY_COLLEGE
                )
                .antMatchers(
                        "/sys/**"
                )
                .hasAnyAuthority(
                        Authority.AUTHORITY_ADMIN
                )
                .anyRequest().permitAll().and().csrf().disable();
        //权限不足时处理
        http.exceptionHandling()
                //未登录处理
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        String xRequestedWith = request.getHeader("x-requested-with");
                        if ("XMLHttpRequest".equals(xRequestedWith)) {
                            //异步请求处理
                            response.setContentType("application/plain;charset=utf-8");
                            PrintWriter writer = response.getWriter();
                            writer.write(JSONUtil.toJsonStr(Result.error(403,"你还没有登录！")));
                        }
                    }
                })
                //登录但权限不足处理
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        String xRequestedWith = request.getHeader("x-requested-with");
                        if ("XMLHttpRequest".equals(xRequestedWith)) {
                            //异步请求处理
                            response.setContentType("application/plain;charset=utf-8");
                            PrintWriter writer = response.getWriter();
                            writer.write(JSONUtil.toJsonStr(Result.error(403,"你没有访问此功能的权限")));
                        }
                    }
                });

        // security会默认拦截logout请求，进行退出处理
        // 覆盖它默认逻辑，才能执行自己的退出代码
        http.logout().logoutUrl("/securityLogout");
    }
}
