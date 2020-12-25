package com.star.mall.persistence.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.persistence.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
public interface IUserService extends IService<User> {
    IPage<User> queryRoleUsers(IPage page, Wrapper wrapper);
}
