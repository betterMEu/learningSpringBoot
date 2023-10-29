package one.two.three;

import one.two.three.components.CustomSpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LearningSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LearningSpringBootApplication.class, args);
		Class<?> beanType = context.getType("roleService");
	}

}
