package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.base.BaseController;
import com.star.mall.base.query.Query;
import com.star.mall.persistence.manager.UserManager;
import com.star.mall.persistence.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController<UserManager,User> {

    @GetMapping("/all")
    public List<User> users(){
        return service.list();
    }

    @PostMapping(value = "/query", produces = { MediaType.APPLICATION_JSON_VALUE })
    public IPage userPage(@RequestBody Query query){
        return service.page(query.getPage(),query.convert2Wrapper());
    }
}
