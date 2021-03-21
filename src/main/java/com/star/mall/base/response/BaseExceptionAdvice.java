package com.star.mall.base.response;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * @author StarQ
 * @since 2021-03-21
 */
@ControllerAdvice(basePackages = "com.star.mall.controller")
public class BaseExceptionAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public BaseResponse runtimeException(RuntimeException exception) {
        exception.printStackTrace();
        return new BaseResponse(ResponseCode.RUNTIME_ERROR, exception.getMessage(),null);
    }
}
