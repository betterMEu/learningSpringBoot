package one.two.three;

import java.util.function.Function;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/11/28 10:57
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        String str1 = "1";
        Function<String, String> function = str -> str;
        System.out.println(function.apply(str1));
    }


}