package one.two.three.controller;

import jakarta.annotation.Resource;
import one.two.three.config.ApplicationObserver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('ROLE_TEST')")
@RequestMapping("/test")
public class TestController {

    @Value("${app.java.version}")
    private String javaVersion;

    @Value("${app.encoding}")
    private String enCoding;

    @Resource
    private ApplicationObserver applicationObserver;

    @Resource
    private JdbcUserDetailsManager jdbcUserDetailsManager;

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

    @GetMapping("/getAuthorities")
    public String getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user.getUsername()
                + "     "
                + user.getAuthorities()
                + "     "
                + "USER组的用户：" + jdbcUserDetailsManager.findUsersInGroup("USER")
                + "     "
                + user.getUsername() + "在USER组：" + jdbcUserDetailsManager.findUsersInGroup("USER").contains(user.getUsername())
                + "     "
                + "USER组的权限：" + jdbcUserDetailsManager.findGroupAuthorities("USER");

    }
}
