package net.maku.framework.security.config;

import lombok.AllArgsConstructor;
import net.maku.framework.security.exception.FastWebResponseExceptionTranslator;
import net.maku.framework.security.token.FastTokenEnhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 认证服务器配置
 *
 * @author 阿沐 babamu@126.com
 */
@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;  //认证管理器
    private final ClientDetailsService fastClientDetailsService;  //将客户端client id secret这些信息存储到数据库
    private final UserDetailsService userDetailsService;  //加载用户信息
    private final AuthorizationCodeServices redisAuthorizationCodeServices;  //授权码
    private final TokenStore tokenStore;   //JWT令牌存储方案

    /**
     * 配置客户端信息
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(fastClientDetailsService);  //从数据库加载认证信息
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.DELETE);
        // 密码模式
        endpoints.authenticationManager(authenticationManager);
        // 支持刷新令牌
        endpoints.userDetailsService(userDetailsService);
        // 令牌管理
        endpoints.tokenStore(tokenStore);
        // 令牌增强
        endpoints.tokenEnhancer(tokenEnhancer());
        // 登录或者鉴权失败时的返回信息
        endpoints.exceptionTranslator(new FastWebResponseExceptionTranslator());
        // 配置授权码模式，存放在Redis中
        endpoints.authorizationCodeServices(redisAuthorizationCodeServices);
        // 自定义登录地址
        endpoints.pathMapping("/oauth/token","/sys/oauth/token");
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new FastTokenEnhancer();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
            .allowFormAuthenticationForClients()
            .tokenKeyAccess("permitAll()")   // 匿名可访问/oauth/token_key
            .checkTokenAccess("isAuthenticated()") // 认证后可访问/oauth/check_token
        ;
    }
}