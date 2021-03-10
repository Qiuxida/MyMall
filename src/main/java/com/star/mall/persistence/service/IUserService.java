package com.star.mall.persistence.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
import com.star.mall.persistence.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  用户服务类
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
public interface IUserService extends IService<User> {
    IPage<User> queryRoleUsers(Query query);

    IPage<User> queryOrgUsers(Query query);
}
