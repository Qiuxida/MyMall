package com.star.mall.controller;

import com.star.mall.model.UserDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @PostMapping("auth")
    public String auth(@RequestBody UserDetail userDetail){
        return "";
    }
}
