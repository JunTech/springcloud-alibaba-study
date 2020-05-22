package top.juntech.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 0:33
 * @ClassName 类名
 * @Descripe 主启动类
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"top.juntech.springcloud.mapper"})
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
