package one.two.three.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 余龙声
 * @Description: @ComponentScan注解告诉Spring在ApplicationConfiguration类所在的包和子包中搜索其他的组件
 * @Date: 2023/10/17 19:47
 * @Version: 1.0
 */
@Configuration
@ComponentScan
public class ApplicationConfiguration {
}
