package one.two.three.components.commandLineRunner;

import jakarta.annotation.Resource;
import one.two.three.properties.StorageProperties;
import one.two.three.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(StorageProperties.class)
public class MySecondCommandLineRunner implements CommandLineRunner {

    @Resource
    private Environment environment;

    @Resource
    private StorageService storageService;

    @Override
    public void run(String... args) {
        // Do something...
        storageService.deleteAll();
        storageService.init();
    }
}
