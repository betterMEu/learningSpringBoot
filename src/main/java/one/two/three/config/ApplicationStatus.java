package one.two.three.config;

import jakarta.annotation.Resource;
import org.springframework.boot.availability.*;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 余龙声
 * @Description: 获取应用的运行状态
 * @Date: 2023/10/9 14:40
 * @Version: 1.0
 */
@Configuration
public class ApplicationStatus {

    @Resource
    private ApplicationAvailability applicationAvailability;

    public String printApplicationState() {
        LivenessState livenessState = applicationAvailability.getState(LivenessState.class);
        ReadinessState readinessState = applicationAvailability.getState(ReadinessState.class);
        return "LivenessState: " +
                (livenessState.equals(LivenessState.CORRECT) ? "正确" : "损坏") +
                " " +
                "ReadinessState: " +
                (readinessState.equals(ReadinessState.ACCEPTING_TRAFFIC) ? "接受请求" : "拒绝请求");
    }
}
