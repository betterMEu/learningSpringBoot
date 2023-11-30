package one.two.three;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/30 11:03
 * @Version: 1.0
 */
@SpringBootTest
public class LogicDeleteTest {

    @Value("${app.random}")
    private Object ran1;

//    @Value("${app.random}")
//    private Integer ran2;

    @Test
    void test() {
        System.out.println(ran1);
//        System.out.println(ran2);
    }
}
