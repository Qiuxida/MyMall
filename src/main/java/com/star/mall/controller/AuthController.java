package com.star.mall.controller;

import com.star.mall.base.response.BaseResponse;
import com.star.mall.base.response.ResponseCode;
import com.star.mall.model.UserDetail;
import com.star.mall.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("auth")
    public BaseResponse auth(@RequestBody UserDetail userDetail){
        String token = authService.login(userDetail.getUsername(),userDetail.getPassword());
        if (token == null) {
            return new BaseResponse<String>(ResponseCode.VALIDATE_ERROR.getCode(),"认证失败",null);
        }
        return new BaseResponse<String>(ResponseCode.SUCCESS.getCode(),"认证成功", token);
    }
}
