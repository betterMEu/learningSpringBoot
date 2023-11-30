package one.two.three;

import jakarta.annotation.Resource;
import one.two.three.entity.User;
import one.two.three.mapper.UserMapper;
import one.two.three.service.UserService;
import org.junit.jupiter.api.Test;
import one.two.three.mapper.RoleMapper;
import one.two.three.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/30 11:03
 * @Version: 1.0
 */
@SpringBootTest
public class LogicDeleteTest {

    @Resource
    private UserService userService;
    private UsersMapper usersMapper;

    @Test
    void testLogicDelete() {
        usersMapper.deleteById("user");
    }

    @Resource
    private UserMapper userMapper;

    @Test
    void test() {
        userMapper.insert(User.builder()
                .USERNAME("guest")
                .PASSWORD("123456")
                .ENABLED(1)
                .build());
//        userMapper.deleteById("admin");
    }
}
