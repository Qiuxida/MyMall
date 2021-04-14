package com.star.mall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.star.mall.model.UserDetail;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (ObjectUtil.isEmpty(user)) {
            throw new UsernameNotFoundException("未找到用户");
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setUsername(user.getAccount());
        userDetail.setPassword(user.getPassword());
        return userDetail;
    }
}
