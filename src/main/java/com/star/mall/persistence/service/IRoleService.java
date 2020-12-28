package com.star.mall.persistence.service;

import com.star.mall.persistence.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.star.mall.persistence.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
public interface IRoleService extends IService<Role> {

    /**
     * 添加某个角色下的用户
     * @param users
     * @param code
     * @return
     */
    void saveOrUpdateRoleUsers(List<User> users, String code);
}
