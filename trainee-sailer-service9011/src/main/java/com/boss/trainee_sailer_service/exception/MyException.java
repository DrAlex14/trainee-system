package com.boss.trainee_sailer_service.exception;

import lombok.Data;

@Data
public class MyException extends Exception{
    //状态码
    private Integer code;

    //状态信息
    private String message;


    public MyException(){
        super();
    }

    public MyException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
