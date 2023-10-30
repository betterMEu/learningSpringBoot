package one.two.three.exp.ext;

import one.two.three.exp.StorageException;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/30 9:15
 * @Version: 1.0
 */
public class StorageFileNotFoundException extends StorageException {


    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
