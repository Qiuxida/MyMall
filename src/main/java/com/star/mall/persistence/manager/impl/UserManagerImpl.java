package com.star.mall.persistence.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.mall.persistence.manager.UserManager;
import com.star.mall.persistence.mapper.UserMapper;
import com.star.mall.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerImpl extends ServiceImpl<UserMapper,User> implements UserManager {

    @Override
    public List<User> getAll() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return getBaseMapper().selectList(wrapper);
    }
}
