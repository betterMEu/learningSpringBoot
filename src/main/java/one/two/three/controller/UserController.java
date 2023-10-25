package one.two.three.controller;


import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import one.two.three.entity.user.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@PreAuthorize("hasRole('USER')")
public class UserController {

    @Resource
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/change-password")
    public String changePassword(Model model) {
        UserDTO userTemp = new UserDTO();
        userTemp.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", userTemp);
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@Valid @ModelAttribute UserDTO userTemp,
                                 BindingResult result,
                                 Model model) {

        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            errors.forEach(error -> sb.append(error.getField()).append(":").append(error.getDefaultMessage()));
            model.addAttribute("error", sb.toString());
            model.addAttribute("user", userTemp);
            return "change-password";
        }

        try {
            String encryptedPassword = bCryptPasswordEncoder.encode(userTemp.getNewPassword());
            jdbcUserDetailsManager.changePassword(userTemp.getOldPassword(), encryptedPassword);
        } catch (BadCredentialsException badCredentialsException) {
            model.addAttribute("error", "原密码错误！");
            model.addAttribute("user", userTemp);
            return "change-password";
        }

        return "redirect:/login";
    }

}

