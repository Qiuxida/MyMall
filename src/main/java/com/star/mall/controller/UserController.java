package com.star.mall.controller;

import com.star.mall.base.response.BaseResponse;
import com.star.mall.model.UserRoleParam;
import com.star.mall.persistence.entity.Role;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IRoleService;
import com.star.mall.persistence.service.IRoleUserService;
import com.star.mall.persistence.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "用户管理", tags = {"用户管理"})
public class UserController extends BaseController<IUserService, User> {

    @Resource
    IRoleService iRoleService;
    @Resource
    IRoleUserService iRoleUserService;

    @GetMapping("{id}/roles")
    @ApiOperation(value = "根据用户ID获取该用户的角色列表", notes = "根据用户ID获取该用户的角色列表", httpMethod = "GET")
    public List<Role> getUserRoles(@ApiParam(value="用户ID", required = true) @PathVariable String id) {
        return iRoleService.getRolesByUserId(id);
    }

    @PutMapping("{id}/roles")
    @ApiOperation(value = "添加角色到用户中", notes = "添加角色到用户中", httpMethod = "PUT")
    public BaseResponse<Role> putUserRole(@ApiParam(value = "用户ID", required = true) @PathVariable String id,
                                    @ApiParam(value = "角色添加删除ID参数", required = true) @RequestBody UserRoleParam param) {
        iRoleUserService.addRoleByUserId(id, param);
        return BaseResponse.SUCCESS("添加成功");
    }
}
