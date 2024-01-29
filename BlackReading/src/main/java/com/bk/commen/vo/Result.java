package com.bk.commen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 统一返回的一个结果集
 * @author: BlackWarm
 * @date: 2023年 12月 24日  12:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    // 定义需要的数值
    private Integer code;
    private String message;
    private T data;


    // 成功的结果
    public static <T> Result<T> success(){
        // 这里从枚举类拿的是 20000, 是前端框架 vue-element-admin 默认的返回结果,我就不改了
        return new Result<>(CodeNum.SUCCESS.getNum(),"success",null);
    }
    public static <T> Result<T> success(T data){
        // 这里的 20000 是前端框架 vue-element-admin 默认的返回结果,我就不改了
        return new Result<>(CodeNum.SUCCESS.getNum(),"success",data);
    }
    public static <T> Result<T> success(T data, String message){
        // 这里的 20000 是前端框架 vue-element-admin 默认的返回结果,我就不改了
        return new Result<>(CodeNum.SUCCESS.getNum(),message,data);
    }
    public static <T> Result<T> success(String message){
        // 这里的 20000 是前端框架 vue-element-admin 默认的返回结果,我就不改了
        return new Result<>(CodeNum.SUCCESS.getNum(),message,null);
    }

    //失败的结果
    public static <T> Result<T> fail(){
        return new Result<>(CodeNum.FAIL.getNum(),"fail",null);
    }
    public static <T> Result<T> fail(Integer code){
        return new Result<>(code,"fail",null);
    }
    public static <T> Result<T> fail(Integer code, String message){
        return new Result<>(code,message,null);
    }
    public static <T> Result<T> fail(String message){
        return new Result<>(CodeNum.FAIL.getNum(),message,null);
    }
}
