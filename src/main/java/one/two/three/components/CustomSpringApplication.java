package one.two.three.components;

import org.springframework.boot.SpringApplication;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/7 13:42
 * @Version: 1.0
 */
public class CustomSpringApplication extends SpringApplication {

    /**
     * 触发父类启动流程
     */
    public CustomSpringApplication(Class<?>... primarySources) {
        super(primarySources);
    }

    @Override
    protected void logStartupInfo(boolean isRoot) {
        System.out.println("say ma name");
        super.logStartupInfo(isRoot);
    }


}
