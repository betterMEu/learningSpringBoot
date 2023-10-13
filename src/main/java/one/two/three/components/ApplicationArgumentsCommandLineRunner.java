package one.two.three.components;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;
import java.util.Arrays;


/**
 * @Author: 余龙声
 * @Description:
        需要在 SpringApplication 启动后运行一些特定的代码，你可以实现 ApplicationRunner 或 CommandLineRunner 接口。
        这两个接口以相同的方式工作，并提供一个单一的 run 方法，该方法在 SpringApplication.run(…​) 执行完毕之前被调用。
        这很适合用于执行那些需要在处理HTTP请求之前执行的任务。
 * @Date: 2023/10/9 14:40
 * @Version: 1.0
 */
@Component
@Order(1)
public class ApplicationArgumentsCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationArgumentsCommandLineRunner.class);

    /**
     * ApplicationArguments接口只能用来获取命令行参数，不能用来获取环境变量或者配置文件中的属性.
     * 命令行参数通常用于配置你的应用程序的行为，而不是用于传递你的应用程序的数据。
     */
    private final ApplicationArguments arguments;


    public ApplicationArgumentsCommandLineRunner(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public void run(String... args) throws NamingException {

        logger.info("————获取启动时参数————");
        logger.info(Arrays.toString(arguments.getSourceArgs()));


    }

}
