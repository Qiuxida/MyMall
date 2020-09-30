package com.star.mall.base.response;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public BaseResponse runtimeException(RuntimeException exception) {
        return new BaseResponse(ResponseCode.RUNTIME_ERROR.getCode(), exception.getMessage(),null);
    }
}
