package top.juntech.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/5/21 0:43
 * @ClassName 类名
 * @Descripe 封装的结果集
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class CommonResult<T> implements Serializable {
    //404 not found
    private Integer code;
    private String message;
    private  T     data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
