package one.two.three.components.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import one.two.three.components.ApplicationArgumentsCommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/19 16:55
 * @Version: 1.0
 */
public class TestFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TestFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String tenantId = request.getHeader("Cookie");
        System.out.println(tenantId);
        boolean hasAccess = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        if (hasAccess) {
            filterChain.doFilter(request, response);
            return;
        }
        throw new AccessDeniedException("滚！");
    }

}
