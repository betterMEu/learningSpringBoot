package one.two.three.components.commandLineRunner;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Component
@Order(2)
public class MySecondCommandLineRunner implements CommandLineRunner {

    @Resource
    private Environment environment;

    @Override
    public void run(String... args) {
        // Do something...

    }
}
