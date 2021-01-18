package com.star.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.persistence.entity.Role;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IRoleService;
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
public class RoleController extends BaseController<IRoleService, Role> {

    @Resource
    IUserService userService;

    @PostMapping("/{code}/user/page")
    public IPage<User> getUsersByRoleId(@RequestBody IPage page, @PathVariable("code") String code) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("ur.code_", code);
        return userService.queryRoleUsers(page,wrapper);
    }

    @PostMapping("/{code}/users")
    public BaseResponse createRoleUsers(@RequestBody List<User> users, @PathVariable("code") String code) {
        service.saveOrUpdateRoleUsers(users, code);
        return BaseResponse.SUCCESS("保存成功");
    }
}
