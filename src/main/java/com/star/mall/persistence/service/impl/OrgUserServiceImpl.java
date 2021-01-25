package com.star.mall.persistence.service.impl;

import com.star.mall.persistence.entity.OrgUser;
import com.star.mall.persistence.mapper.OrgUserMapper;
import com.star.mall.persistence.service.IOrgUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织用户表  服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2021-01-23
 */
@Service
public class OrgUserServiceImpl extends ServiceImpl<OrgUserMapper, OrgUser> implements IOrgUserService {

}
