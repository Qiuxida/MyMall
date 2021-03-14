package com.star.mall.persistence.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.star.mall.persistence.entity.Role;
import com.star.mall.persistence.entity.RoleUser;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.mapper.RoleMapper;
import com.star.mall.persistence.mapper.RoleUserMapper;
import com.star.mall.persistence.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.mall.persistence.service.IRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  角色服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2020-12-25
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    IRoleUserService roleUserService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateRoleUsers(List<String> userIds, String id) {
        Role role = getById(id);
        if (ObjectUtil.isNotEmpty(role)) {
            userIds.forEach(userId -> {
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("user_id_", userId);
                wrapper.eq("role_id_", id);
                RoleUser roleUser = roleUserService.getOne(wrapper);
                if (ObjectUtil.isEmpty(roleUser)) {
                    roleUser = new RoleUser();
                    roleUser.setUserId(userId);
                    roleUser.setRoleId(id);
                    roleUserService.save(roleUser);
                }
            });
        }else
            throw new RuntimeException("不存在此角色");
    }

    @Override
    public List<Role> getRolesByUserId(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uru.user_id_", id);
        wrapper.eq("r.deleted_", "0");
        return baseMapper.getRolesWithUser(wrapper);
    }

}
