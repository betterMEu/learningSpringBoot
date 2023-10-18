package one.two.three.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: 余龙声
 * @Description: AbstractAnnotationConfigDispatcherServletInitializer类是Spring MVC应用的启动器
 * @Date: 2023/10/17 19:37
 * @Version: 1.0
 */
public class SecurityInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 返回一个包含这些配置类的数组。如果你返回null，那就意味着你没有提供任何根配置类。
     * 根配置类通常用于配置应用的“根”上下文，这是共享在所有Servlet和过滤器之间的上下文。这通常包括数据源、服务类、存储库类等等。
     * 如果你想要配置Spring MVC的Servlet上下文（例如视图解析器、处理器映射等），你应该覆盖getServletConfigClasses()方法，而不是getRootConfigClasses()方法。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * 返回一个包含配置类的数组，这些配置类定义了应用的Servlet上下文
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ApplicationConfiguration.class };
    }

    /**
     * 返回一个字符串数组，这些字符串定义了应用中DispatcherServlet的URL映射
     * 返回了一个只包含"/"的数组，意味着DispatcherServlet将处理应用中所有的请求
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}