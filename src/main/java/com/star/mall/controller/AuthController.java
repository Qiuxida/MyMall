package com.star.mall.controller;

import cn.hutool.core.util.StrUtil;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.base.response.ResponseCode;
import com.star.mall.model.UserDetail;
import com.star.mall.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 认证接口
 * @author StarQ
 * @since 2021-04-16
 */
@RestController
@RequestMapping("/mall/v1")
@Api(value = "登录认证", tags = {"登录认证"})
public class AuthController {

    @Resource
    AuthService authService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "登录", httpMethod = "POST")
    public BaseResponse login(@RequestBody UserDetail userDetail) {
        String token = authService.login(userDetail.getUsername(), userDetail.getPassword());
        if (StrUtil.isEmpty(token)) {
            return new BaseResponse<String>(ResponseCode.VALIDATE_ERROR,"认证失败",null);
        }
        return new BaseResponse<>(ResponseCode.SUCCESS,"认证成功", token);
    }

}
