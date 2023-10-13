package one.two.three;

import one.two.three.components.CustomSpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Arrays;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LearningSpringBootApplication {

	public static void main(String[] args) {
//		CustomSpringApplication.run(LearningSpringBootApplication.class, args);
		new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)				// banner模式-打印
				.sources(LearningSpringBootApplication.class)
				.lazyInitialization(Boolean.TRUE)				// 懒加载-启用
				.run(args);
	}

}
