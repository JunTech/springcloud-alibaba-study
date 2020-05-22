package top.juntech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/22 13:50
 * @ClassName 类名
 * @Descripe 描述
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3344.class,args);
    }
}
