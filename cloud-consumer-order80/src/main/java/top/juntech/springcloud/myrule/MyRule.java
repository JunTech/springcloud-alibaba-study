package top.juntech.springcloud.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 21:11
 * @ClassName 类名
 * @Descripe 描述
 */
//@Configuration
public class MyRule  {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
