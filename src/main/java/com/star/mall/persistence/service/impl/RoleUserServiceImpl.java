package com.star.mall.persistence.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.star.mall.model.UserRoleParam;
import com.star.mall.persistence.entity.RoleUser;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.mapper.RoleUserMapper;
import com.star.mall.persistence.service.IRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2021-01-25
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements IRoleUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoleByUserId(String id, UserRoleParam param) {
        List<RoleUser> roleUsers = param.getAddIds().stream().map(roleId -> {
            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(id);
            return roleUser;
        }).collect(Collectors.toList());
        saveBatch(roleUsers);

        if (CollectionUtil.isNotEmpty(param.getDeleteIds())) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.in("role_id_", param.getDeleteIds());
            wrapper.eq("user_id_", id);
            remove(wrapper);
        }

    }
}
