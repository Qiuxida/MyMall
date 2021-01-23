package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
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

    @PostMapping("/user/page")
    public IPage<User> getUsersByRoleId(@RequestBody Query query) {
        return userService.queryRoleUsers(query);
    }

    @PostMapping("/{code}/users")
    public BaseResponse createRoleUsers(@RequestBody List<User> users, @PathVariable("code") String code) {
        service.saveOrUpdateRoleUsers(users, code);
        return BaseResponse.SUCCESS("保存成功");
    }
}
