package one.two.three.config.mvc;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import one.two.three.config.SecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNullApi;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Servlet，不需要@Configuration
 */
@Configuration
@EnableWebMvc
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 用于配置应用程序的根配置类。这些配置类通常包含与应用程序的业务逻辑相关的 bean
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {

        System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        return null;
    }

    /**
     * 配置 DispatcherServlet 的配置类。这些配置类通常包含与 Spring MVC 相关的 bean，如控制器、视图解析器等
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    /**
     * 指定 DispatcherServlet 映射的 URL 模式
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }


    /**
     * 多部分上传配置，MultipartConfigElement四个属性
     * 1）<location> 元素指定了上传文件的临时存储位置
     * 2）<max-file-size> 元素指定了单个文件的最大大小
     * 3）<max-request-size> 元素指定了整个请求的最大大小
     * 4）<file-size-threshold> 元素指定了文件大小超过该阈值时，文件将被写入磁盘而不是内存。
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }
}