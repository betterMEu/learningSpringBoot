package one.two.three.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import one.two.three.entity.Users;
import one.two.three.service.UsersService;
import one.two.three.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-10-31 16:02:06
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




