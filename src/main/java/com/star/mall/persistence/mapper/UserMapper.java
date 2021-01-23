package com.star.mall.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.persistence.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
public interface UserMapper extends BaseMapper<User> {

    Page<User> queryRoleUsers(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);

    Page<User> queryOrgUsers(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
