package top.juntech.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.springcloud.entities.Payment;

@Mapper
public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}