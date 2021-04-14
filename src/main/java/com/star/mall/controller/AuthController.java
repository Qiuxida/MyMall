package com.star.mall.controller;

import cn.hutool.core.util.StrUtil;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.base.response.ResponseCode;
import com.star.mall.model.UserDetail;
import com.star.mall.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mall/v1")
public class AuthController {

    @Resource
    AuthService authService;

    @PostMapping("/login")
    public BaseResponse auth(@RequestBody UserDetail userDetail){
        String token = authService.login(userDetail.getUsername(), userDetail.getPassword());
        if (StrUtil.isEmpty(token)) {
            return new BaseResponse<String>(ResponseCode.VALIDATE_ERROR,"认证失败",null);
        }
        return new BaseResponse<>(ResponseCode.SUCCESS,"认证成功", token);
    }
}
