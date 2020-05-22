package top.juntech.springcloud.service;

import org.springframework.stereotype.Component;
import top.juntech.springcloud.entities.Payment;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 0:56
 * @ClassName 类名
 * @Descripe 支付业务接口
 */
@Component
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(long id);
}
