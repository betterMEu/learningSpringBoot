package one.two.three.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/18 17:24
 * @Version: 1.0
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/403")
    public String index() {
        return "error/403";
    }
}
