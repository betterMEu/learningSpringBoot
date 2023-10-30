package one.two.three.exp;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/30 9:13
 * @Version: 1.0
 */
public class StorageException extends RuntimeException{

    public StorageException(String msg) {
        super(msg);
    }

    public StorageException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
