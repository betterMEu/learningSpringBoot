package one.two.three.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/12 9:58
 * @Version: 1.0
 */
@ControllerAdvice(basePackages = "org.springframework.security.web.authentication.session")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SessionAuthenticationException.class)
    public ResponseEntity<String> handleException(SessionAuthenticationException e) {
        System.out.println(e.getMessage());
        // 重写异常信息
        String errorMessage = "An error occurred: 已登录，请勿重复登录！";
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
