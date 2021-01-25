package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.persistence.entity.Role;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IRoleService;
import com.star.mall.persistence.service.IRoleUserService;
import com.star.mall.persistence.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author 邱喜达
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/mall/role")
public class RoleController extends BaseController<IRoleService, Role> {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleUserService roleUserService;

    @PostMapping("/users/page")
    public IPage<User> getUsersPage(@RequestBody Query query) {
        return userService.queryRoleUsers(query);
    }

    @PostMapping("/{id}/users")
    public BaseResponse createRoleUsers(@RequestBody List<String> userIds, @PathVariable("id") String id) {
        service.saveOrUpdateRoleUsers(userIds, id);
        return BaseResponse.SUCCESS("保存成功");
    }

    @DeleteMapping("/users")
    public BaseResponse deleteRoleUsers(@RequestParam("ids") String ...ids) {
        roleUserService.removeByIds(Arrays.asList(ids));
        return BaseResponse.SUCCESS("删除成功");
    }
}
