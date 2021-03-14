package com.star.mall.persistence.service;

import com.star.mall.model.UserRoleParam;
import com.star.mall.persistence.entity.RoleUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.star.mall.persistence.entity.User;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author StarQ
 * @since 2021-01-25
 */
public interface IRoleUserService extends IService<RoleUser> {

    void addRoleByUserId(String id, UserRoleParam param);
}
