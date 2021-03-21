package com.star.mall.base.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1086450824746075249L;
    //状态码
    private Integer code;
    //提示
    private String message;
    //返回数据
    private T data;

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

    public static <T> BaseResponse<T> SUCCESS(String message) {
        return new BaseResponse<T>(ResponseCode.SUCCESS, message,null);
    }

    public static <T> BaseResponse<T> FAIL(String message) {
        return new BaseResponse<T>(ResponseCode.RUNTIME_ERROR, message,null);
    }

}
