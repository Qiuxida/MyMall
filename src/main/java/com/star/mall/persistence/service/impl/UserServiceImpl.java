package com.star.mall.persistence.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.mapper.UserMapper;
import com.star.mall.persistence.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Page<User> queryRoleUsers(IPage page, Wrapper wrapper) {
        return baseMapper.queryRoleUsers(page,wrapper);
    }
}