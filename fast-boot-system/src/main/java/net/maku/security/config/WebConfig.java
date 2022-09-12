package net.maku.security.config;

import net.maku.security.interceptor.LoginInterceptor;
import net.maku.security.interceptor.RefreshInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //token刷新拦截器
        registry.addInterceptor(new RefreshInterceptor(stringRedisTemplate)).addPathPatterns("/**");

        //登录拦截器
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(
                "/login"
        );
    }
}
