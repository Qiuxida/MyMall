package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.base.BaseController;
import com.star.mall.persistence.manager.UserManager;
import com.star.mall.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController<UserManager,User> {

    @Autowired
    UserManager userManager;

    @GetMapping("/users")
    public List<User> users(){
        return userManager.list();
    }

    @PostMapping("/users")
    public IPage userPage(){
        IPage page = new Page(1,1);
        return userManager.page(page);
    }
}
