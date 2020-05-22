package top.juntech.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.juntech.springcloud.common.CommonResult;
import top.juntech.springcloud.entities.Payment;
import top.juntech.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 1:00
 * @ClassName 类名
 * @Descripe 描述
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult result(Payment payment){
        int result = paymentService.create(payment);
        log.debug("****插入结果:{}",result);
        log.debug("调用的服务的端口：{}",port);
        if(result>0){
            //插入成功
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.debug("根据id查询到的结果为：{}",payment);
        log.debug("调用的服务的端口：{}",port);
        if(payment!=null){
            return new CommonResult(200,"该端口："+port+"查询成功",payment);
        }else {
            return new CommonResult(404,"没有该id"+id+"对应记录",null);
        }
    }

    @GetMapping("/payment/discoveryclient")
    public Object dicovery(){
        //获取服务实例
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.debug("*******element:{}",element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.debug(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/test")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            log.debug("出现异常：{}",e.getMessage());
        }

        return port;
    }

    @GetMapping("/payment/lb")
    public CommonResult lb(@Param("uname")String uname){
        log.debug("lb方法...");
        if(uname==null){
            return new CommonResult(400,"uanme为空");
        }
        return new CommonResult(200,"该端口："+port+"查询成功,用户名为:"+uname);
    }


}
