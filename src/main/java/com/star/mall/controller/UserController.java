package com.star.mall.controller;

import com.star.mall.base.response.BaseResponse;
import com.star.mall.model.UserRoleParam;
import com.star.mall.persistence.entity.Role;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IRoleService;
import com.star.mall.persistence.service.IRoleUserService;
import com.star.mall.persistence.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import com.star.mall.base.BaseController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  用户
 * </p>
 *
 * @author StarQ
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/mall/user")
@Api("用户管理")
public class UserController extends BaseController<IUserService, User> {

    @Resource
    IRoleService iRoleService;
    @Resource
    IRoleUserService iRoleUserService;

    @GetMapping("{id}/roles")
    public List<Role> getUserRoles(@PathVariable String id) {
        return iRoleService.getRolesByUserId(id);
    }

    @PutMapping("{id}/roles")
    public BaseResponse putUserRole(@PathVariable String id, @RequestBody UserRoleParam param) {
        iRoleUserService.addRoleByUserId(id, param);
        return BaseResponse.SUCCESS("添加成功");
    }
}
