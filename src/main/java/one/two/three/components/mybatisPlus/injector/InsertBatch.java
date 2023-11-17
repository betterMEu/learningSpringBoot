package one.two.three.components.mybatisPlus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/31 20:25
 * @Version: 1.0
 */
public class InsertBatch extends AbstractMethod {

    /**
     * @param methodName 方法名
     * @since 3.5.0
     */
    protected InsertBatch(String methodName) {
        super(methodName);
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {

        //第三个参数必须和baseMapper的自定义方法名一致
//        return this.addInsertMappedStatement(mapperClass, modelClass, methodName, sqlSource, new NoKeyGenerator(), null, null);
        return null;
    }
}
