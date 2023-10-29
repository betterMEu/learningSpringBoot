package one.two.three;

import jakarta.annotation.Resource;
import one.two.three.mapper.RoleMapper;
import one.two.three.mapper.UsersMapper;
import one.two.three.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class sedfsdf {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private RoleService roleService;

    @Test
    void ssfds() {
        
    }
}
