package com.star.mall.base.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局响应处理类
 * @author StarQ
 * @since 2021-3-21
 */
@ControllerAdvice("com.star.mall.controller")
public class BaseResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(MediaType.APPLICATION_JSON.equals(mediaType)){
            if(body instanceof BaseResponse){
                return body;
            }else{
                BaseResponse response =new BaseResponse(ResponseCode.SUCCESS, ResponseCode.SUCCESS.getMessage(),body);
                return response;
            }
        }
        return body;
    }
}
