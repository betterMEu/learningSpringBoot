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

    @Setter
    private List<String> addresses = new ArrayList<>(Arrays.asList("a", "b", "c"));

    @Setter
    private ContainerType containerType = ContainerType.SIMPLE;

    // getters/setters ...

    public enum ContainerType {

        SIMPLE, DIRECT

    }

    private Map<String, Integer> contexts;

    public void setContexts(Map<String, Integer> contexts) {
        this.contexts = contexts;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Deprecated
    @DeprecatedConfigurationProperty(replacement = "test.property.age", reason = "无用")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
