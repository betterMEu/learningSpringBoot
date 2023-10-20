package one.two.three.service;

import lombok.Data;
import one.two.three.entity.TestUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/19 9:41
 * @Version: 1.0
 */
@Service
public class TestService {

    @PreAuthorize("hasAnyRole('ADMIN')")
    public String testMethodSafe() {
        return "你真有本事";
    }

    /**
     * 用于在方法调用之前对集合类型的输入参数进行过滤，指定一个SpEL表达式将被应用到方法的每个输入参数上，只有当表达式的结果为true时，对应的参数才会被包含在方法调用中。
     * 下方表示只有当集合中的对象的owner属性等于当前认证用户的name属性时，该对象才会被包含在方法调用中。
     * @param Pre-filtering
     */
    @PreFilter("filterObject.owner == authentication.name")
    public Collection<TestUser> updateAccounts(Collection<TestUser> testUsers) {
        // ... `accounts` will only contain the accounts owned by the logged-in user
        return testUsers;
    }
}
