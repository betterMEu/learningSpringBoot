package one.two.three.controller;


import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping("/grant-authorities")
    public String getGrantAuthorities(Model model) {
        User user = (User) jdbcUserDetailsManager.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return "grant-authorities";
    }

    @PostMapping("/grant-authorities")
    public ResponseEntity<String> grantAuthorities() {

        return ResponseEntity.ok("success");
    }
}
