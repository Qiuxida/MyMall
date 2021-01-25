package com.star.mall.persistence.service.impl;

import com.star.mall.persistence.entity.RoleUser;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.mapper.RoleUserMapper;
import com.star.mall.persistence.service.IRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
