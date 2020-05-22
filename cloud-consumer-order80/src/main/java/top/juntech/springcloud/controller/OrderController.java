package top.juntech.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.juntech.springcloud.common.CommonResult;
import top.juntech.springcloud.entities.Payment;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 16:28
 * @ClassName 类名
 * @Descripe 描述
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE/payment/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("消费者调用create方法...");
        return restTemplate.postForObject(PAYMENT_URL+"create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        log.info("消费者调用getPaymentById方法...");
        return restTemplate.getForObject(PAYMENT_URL+"get/"+id,CommonResult.class);
    }


}
