package one.two.three.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/19 9:59
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class TestUser {
    String owner;

    int age;
}