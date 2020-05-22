package top.juntech.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.juntech.springcloud.entities.Payment;
import top.juntech.springcloud.mapper.PaymentMapper;
import top.juntech.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 0:57
 * @ClassName PaymentServiceImpl
 * @Descripe 支付业务实现
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
