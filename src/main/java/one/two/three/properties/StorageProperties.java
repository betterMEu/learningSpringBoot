package one.two.three.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/30 9:12
 * @Version: 1.0
 */
@ConfigurationProperties("storage")
@Data
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

}
