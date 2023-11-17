package one.two.three.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import one.two.three.entity.User;
import one.two.three.service.UserService;
import one.two.three.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-10-31 11:54:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




