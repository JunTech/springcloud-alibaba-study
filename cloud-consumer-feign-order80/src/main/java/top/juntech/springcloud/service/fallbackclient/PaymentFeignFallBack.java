package top.juntech.springcloud.service.fallbackclient;

import org.springframework.stereotype.Component;
import top.juntech.springcloud.common.CommonResult;
import top.juntech.springcloud.entities.Payment;
import top.juntech.springcloud.service.PaymentFeignService;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 23:50
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public class PaymentFeignFallBack implements PaymentFeignService {
    @Override
    public CommonResult create(Payment payment) {
        return new CommonResult(400,"插入错误....");
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(400,"查询不到数据....");
    }

    @Override
    public String paymentFeignTimeout() {
        return "超时了....";
    }
}
