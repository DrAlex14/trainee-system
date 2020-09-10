package com.boss.trainee_sailer_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 状态码
 * 200 请求已正常处理
 * 204 No Content: 请求处理成功，但没有资源返回给前端
 * 206 Partial Content: 对资源某一部分的请求
 *
 * 301Moved
 *
 * @author 张卓毅
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}

