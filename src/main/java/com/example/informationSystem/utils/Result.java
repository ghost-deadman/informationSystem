package com.example.informationSystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.codec.ServerSentEvent;

/**
 * @author by cdh
 * @description 公共返回对象
 * @date ：Created in 2022/9/16 9:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private long code;

    private String message;

    private Object obj;

    public static Result success(String message){
        return new Result(200,message,null);
    }

    public static Result success(String message,Object obj){
        return new Result(200,message,obj);
    }

    public static Result error(String message){
        return new Result(500,message,null);
    }

    public static Result error(String message,Object obj){
        return new Result(500,message,obj);
    }

}