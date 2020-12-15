package com.star.mall.base.response;

public enum ResponseCode {
    SUCCESS(0,"请求成功"),
    RUNTIME_ERROR(40001,"运行时错误"),
    VALIDATE_ERROR(40002, "认证失败");

    private Integer code;
    private String message;

    ResponseCode(Integer code,String message){
        this.code = code;
        this.message = message;
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
}
