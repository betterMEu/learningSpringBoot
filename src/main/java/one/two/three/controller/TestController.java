package one.two.three.controller;

import jakarta.annotation.Resource;
import one.two.three.config.ApplicationObserver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${app.java.version}")
    private String javaVersion;

    @Value("${app.encoding}")
    private String enCoding;

    @Resource
    private ApplicationObserver applicationObserver;

    @GetMapping("/getJavaVersion")
    public String getProperty() {
        return javaVersion;
    }

    @GetMapping("/getCoding")
    public String getCoding() {
        return enCoding;
    }

    @GetMapping("/applicationState")
    public String getApplicationState() {
        return applicationObserver.printApplicationState();
    }
}
