package top.juntech.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import top.juntech.springcloud.common.CommonResult;
import top.juntech.springcloud.entities.Payment;
import top.juntech.springcloud.service.fallbackclient.PaymentFeignFallBack;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 23:47
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFeignFallBack.class)
public interface PaymentFeignService {

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/test")
    public String paymentFeignTimeout();
}
