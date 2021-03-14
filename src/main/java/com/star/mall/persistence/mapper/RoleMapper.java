package com.star.mall.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.star.mall.persistence.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  角色Mapper 接口
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据条件获取角色表
     * @param wrapper
     * @return
     */
    List<Role> getRolesWithUser(@Param(Constants.WRAPPER) Wrapper wrapper);

}
