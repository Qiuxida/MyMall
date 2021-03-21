package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.persistence.entity.Org;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IOrgService;
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
 * 组织表  前端控制器
 * </p>
 *
 * @author StarQ
 * @since 2021-01-17
 */
@RestController
@RequestMapping("/mall/org")
@Api(value = "组织管理", tags = {"组织管理"})
public class OrgController extends BaseController<IOrgService, Org> {

    @Resource
    IUserService userService;

    @GetMapping("/tree/{orgId}")
    @ApiOperation(value = "获取组织树", httpMethod = "GET", notes = "获取组织树")
    public List<Org> getOrgTree(@ApiParam(value = "组织ID", name="orgId", required = true) @PathVariable String orgId) {
        return service.getOrgTree(orgId);
    }

    @PostMapping("/parent")
    @ApiOperation(value = "获取组织树", httpMethod = "GET", notes = "获取组织树")
    public BaseResponse<Org> addByParentId(@ApiParam(value = "组织", name = "org", required = true) @RequestBody Org org) {
        service.addByParentId(org);
        return BaseResponse.SUCCESS("保存成功");
    }

    @PostMapping("/users/page")
    @ApiOperation(value = "获取组织用户分页", httpMethod = "POST", notes = "获取组织用户分页")
    public IPage<User> getUsersByCode(@ApiParam(value = "查询参数", name = "query", required = true) @RequestBody Query<User> query) {
        return userService.queryOrgUsers(query);
    }

    @PostMapping("/{id}/users")
    @ApiOperation(value = "在某组织下添加用户", httpMethod = "POST", notes = "在某组织下添加用户")
    public BaseResponse<Org> createOrgUsers(@ApiParam(value = "用户ID集", name = "userIds", required = true) @RequestBody List<String> userIds,
                                            @ApiParam(value = "组织ID", name = "id", required = true) @PathVariable String id) {
        service.saveOrUpdateOrgUsers(userIds, id);
        return BaseResponse.SUCCESS("保存成功");
    }

}
