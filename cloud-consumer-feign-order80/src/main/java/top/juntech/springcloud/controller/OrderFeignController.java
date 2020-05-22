package top.juntech.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.juntech.springcloud.common.CommonResult;
import top.juntech.springcloud.entities.Payment;
import top.juntech.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 23:51
 * @ClassName 类名
 * @Descripe 描述
 */
@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Resource
    private Environment env;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("消费者调用create方法...");
        log.debug("端口:{}",env.getProperty("server.port"));
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        log.info("消费者调用getPaymentById方法...");
        log.debug("端口:{}",env.getProperty("server.port"));
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/test")
    public String paymentFeignTimeout(){
        log.info("测试feign超时...");
        return paymentFeignService.paymentFeignTimeout();
    }
}
