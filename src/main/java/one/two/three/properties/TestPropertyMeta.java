package one.two.three.properties;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "test.property")
public class TestPropertyMeta {

    private String name;

    /**
    * 年龄
    */
    private int age = 18;

    private List<String> addresses = new ArrayList<>(Arrays.asList("a", "b", "c"));

    private ContainerType containerType = ContainerType.SIMPLE;


    public enum ContainerType {
        SIMPLE, DIRECT
    }

    private Map<String, Integer> contexts;


    @Deprecated
    @DeprecatedConfigurationProperty(replacement = "test.property.age", reason = "无用")
    public int getAge() {
        return age;
    }

}
