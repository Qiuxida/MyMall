package com.star.mall.persistence.manager;

import com.baomidou.mybatisplus.extension.service.IService;
import com.star.mall.persistence.model.User;

import java.util.List;

public interface UserManager extends IService<User> {

    List<User> getAll();
}
