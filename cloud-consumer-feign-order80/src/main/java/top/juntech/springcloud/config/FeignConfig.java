package top.juntech.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/22 9:02
 * @ClassName 类名
 * @Descripe feign开启日志功能
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
