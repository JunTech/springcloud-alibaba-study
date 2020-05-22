package top.juntech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/22 10:51
 * @ClassName 类名
 * @Descripe 描述
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudGateWay9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateWay9527.class,args);
    }
}
