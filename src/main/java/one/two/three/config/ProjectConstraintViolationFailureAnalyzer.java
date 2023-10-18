package one.two.three.config;

import org.springframework.beans.factory.support.BeanDefinitionOverrideException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;
import org.springframework.context.ApplicationContextException;

/**
 * @Author: 余龙声
 * @Description: 项目启动失败时，异常信息拦截，对异常类型进行判断，编辑自己的报错信息
 * @Date: 2023/10/9 14:32
 * @Version: 1.0
 */
public class ProjectConstraintViolationFailureAnalyzer extends AbstractFailureAnalyzer<Exception> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, Exception cause) {
        if (cause instanceof ApplicationContextException) {
            if (cause.getCause() instanceof PortInUseException) {
                String message = "端口已被使用，请切换另外的端口号启动！";
                return new FailureAnalysis(message, "更新 application.properties 文件，使用不同的端口号.", cause);
            }
        }

        if (cause instanceof BeanDefinitionOverrideException) {

        }
        // Handle other types of failures if needed
        return null;
    }
}