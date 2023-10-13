package one.two.three.components;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
public class MySecondCommandLineRunner implements CommandLineRunner {

    @Resource
    private Environment environment;

    @Override
    public void run(String... args) {
        // Do something...
        System.out.println("-2-");

    }
}
