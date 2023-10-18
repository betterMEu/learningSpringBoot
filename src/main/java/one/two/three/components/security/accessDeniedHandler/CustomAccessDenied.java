package one.two.three.components.security.accessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 可以拦截多种访问被拒绝的情况。以下是一些常见的情况：
 * 1.认证失败：当用户尝试访问需要身份验证的资源时，但未提供有效的凭据或凭据无效时，访问被拒绝。
 * 2.授权失败：当用户已通过身份验证，但没有足够的权限访问特定资源时，访问被拒绝。
 * 3.CSRF攻击：当请求中的CSRF令牌无效或缺失时，访问被拒绝。
 * 4.Session过期：当用户的会话已过期或无效时，访问被拒绝。
 * 5.IP限制：当用户的IP地址不在允许的IP范围内时，访问被拒绝。
 * 6.请求方法不允许：当用户尝试使用不允许的HTTP请求方法（例如GET、POST、PUT等）访问资源时，访问被拒绝。
 * 7.URL匹配失败：当请求的URL与配置的URL模式不匹配时，访问被拒绝。
 * 实际上，AccessDeniedHandler可以用于拦截任何访问被拒绝的情况。您可以根据您的需求和业务逻辑，在自定义的AccessDeniedHandler实现中处理特定的访问被拒绝情况，并采取适当的操作，例如重定向到错误页面、返回自定义错误消息等。
 */
@Component
public class CustomAccessDenied implements AccessDeniedHandler {

    private static final String ERROR = "/error";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 设置403状态码和自定义的错误页面
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.sendRedirect(ERROR + "/403");
    }
}
