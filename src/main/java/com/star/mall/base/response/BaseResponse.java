package com.star.mall.base.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1086450824746075249L;
    //状态码
    private Integer code;
    //提示
    private String message;
    //返回数据
    private T data;

    public BaseResponse() {}

    public BaseResponse(ResponseCode responseCode, String message, T data) {
        this.code = responseCode.getCode();
        this.message = message;
        this.data = data;
    }
    public BaseResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    public static BaseResponse SUCCESS(String message) {
        return new BaseResponse<>(ResponseCode.SUCCESS, message,null);
    }

    public static BaseResponse FAIL(String message) {
        return new BaseResponse<>(ResponseCode.RUNTIME_ERROR, message,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
