package net.maku.framework.security.exception;

import net.maku.framework.common.exception.ErrorCode;
import net.maku.framework.common.utils.HttpContextUtils;
import net.maku.framework.common.utils.JsonUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 匿名用户(token不存在、错误)，异常处理器
 *被ExceptionTranslationFilter用来作为认证方案的入口，即当用户请求处理过程中遇见认证异常时，
 * 被异常处理器（ExceptionTranslationFilter）用来开启特定的认证流程
 * @author 阿沐 babamu@126.com
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 其中，request是遇到了认证异常的用户请求，response 是将要返回给用户的响应，authException 请求过程中遇见的认证异常。
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
       response.setContentType("application/json; charset=utf-8");
       response.setHeader("Access-Control-Allow-Credentials", "true");
       response.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

       response.getWriter().print(JsonUtils.toJsonString(Result.error(ErrorCode.UNAUTHORIZED)));
    }
}