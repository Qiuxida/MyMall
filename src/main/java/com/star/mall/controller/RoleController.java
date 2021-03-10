package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
import com.star.mall.base.response.BaseResponse;
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
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  角色
 * </p>
 *
 * @author StarQ
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/mall/role")
@Api("角色管理")
public class RoleController extends BaseController<IRoleService, Role> {

    @Resource
    IUserService userService;
    @Resource
    IRoleUserService roleUserService;

    @PostMapping("/users/page")
    @ApiOperation(value = "获取角色下用户分页", httpMethod = "GET", notes = "获取角色下用户分页")
    public IPage<User> getUsersPage(@ApiParam(value = "查询参数", name = "query") @RequestBody Query query) {
        return userService.queryRoleUsers(query);
    }

    @PostMapping("/{id}/users")
    @ApiOperation(value = "在某角色下添加用户", httpMethod = "POST", notes = "在某角色下添加用户")
    public BaseResponse createRoleUsers(@ApiParam(value = "用户ID", name = "userIds") @RequestBody List<String> userIds,
                                        @ApiParam(value = "角色ID", name = "id") @PathVariable("id") String id) {
        service.saveOrUpdateRoleUsers(userIds, id);
        return BaseResponse.SUCCESS("保存成功");
    }

    @DeleteMapping("/users")
    @ApiOperation(value = "批量删除角色下用户", httpMethod = "DELETE", notes = "批量删除角色下用户")
    public BaseResponse deleteRoleUsers(@ApiParam(value = "角色ID", name = "ids") @RequestParam("ids") String ...ids) {
        roleUserService.removeByIds(Arrays.asList(ids));
        return BaseResponse.SUCCESS("删除成功");
    }
}
