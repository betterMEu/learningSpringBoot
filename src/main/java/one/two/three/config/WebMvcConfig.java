package one.two.three.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @Author: 余龙声
 * @Description: web配置，会覆盖 servlet.encoding 配置，使其失效
 * @Date: 2023/10/12 16:48
 * @Version: 1.0
 */
@EnableWebMvc
@Configuration
@Profile("production")
public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }
//
//    //配置文件WEB版本代替
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("classpath:/resources/")
//                /*
//                 * 在生产环境中，可以将缓存期限设置得更长，以提高性能。
//                 * 如果您在开发过程中频繁更改了静态资源，设置较长的缓存期限可能会导致浏览器无法及时获取到最新的资源。可以将缓存期限设置为较短，或者禁用缓存，以便及时获取到最新的资源
//                 */
//                .setCachePeriod(31556926);
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }
//

}