package top.juntech;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/22 11:34
 * @ClassName 类名
 * @Descripe 描述
 */
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test(){
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
