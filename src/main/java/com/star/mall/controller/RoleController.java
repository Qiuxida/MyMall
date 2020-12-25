package com.star.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IUserService;
import org.springframework.web.bind.annotation.*;

import com.star.mall.base.BaseController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  角色
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/mall/role")
public class RoleController extends BaseController {

    @Resource
    IUserService userService;

    @PostMapping("/{roleId}/users")
    public IPage<User> getUsersByRoleId(@RequestBody IPage page, @PathVariable("roleId") String roleId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id_", roleId);
        return userService.queryRoleUsers(page,wrapper);
    }
}
