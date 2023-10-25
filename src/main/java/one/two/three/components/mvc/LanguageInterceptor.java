package one.two.three.components.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/25 10:24
 * @Version: 1.0
 */
public class LanguageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在处理程序执行前执行的逻辑
        String language = request.getParameter("language");
        if (language != null && !language.isEmpty()) {
            // 根据请求参数设置语言
            // 例如，可以使用 LocaleResolver 设置语言
             LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
             localeResolver.setLocale(request, response, new Locale(language));
        }
        return true; // 返回 true 表示继续执行处理程序，返回 false 表示中断执行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 在处理程序执行后、视图渲染前执行的逻辑
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // 在完成请求处理后执行的逻辑
    }
}
