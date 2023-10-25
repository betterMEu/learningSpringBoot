package one.two.three.controller.tip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/25 14:30
 * @Version: 1.0
 */
@Controller
public class SuccessController {

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
