package com.boss.trainee_sailer_service.controller;

import com.boss.trainee_sailer_service.entity.CommonResult;
import com.boss.trainee_sailer_service.exception.MyException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @param
 * @
 */
@Log4j2
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MyException.class)
    public CommonResult handleMyException(MyException exception){
        return new CommonResult(exception.getCode(),exception.getMessage(),null);
    }
}
