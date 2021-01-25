package com.star.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.persistence.entity.Org;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IOrgService;
import com.star.mall.persistence.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.star.mall.base.BaseController;

import java.util.List;

/**
 * <p>
 * 组织表  前端控制器
 * </p>
 *
 * @author 邱喜达
 * @since 2021-01-17
 */
@RestController
@RequestMapping("/mall/org")
public class OrgController extends BaseController<IOrgService, Org> {

    @Autowired
    IUserService userService;

    @GetMapping("/tree/{orgId}")
    public List<Org> getOrgTree(@PathVariable String orgId) {
        return service.getOrgTree(orgId);
    }

    @PostMapping("/parent")
    public BaseResponse addByParentId(@RequestBody Org org) {
        service.addByParentId(org);
        return BaseResponse.SUCCESS("保存成功");
    }

    @GetMapping("/users/page")
    public IPage<User> getUsersByCode(@RequestBody Query query) {
        return userService.queryOrgUsers(query);
    }

    @PostMapping("/{id}/users")
    public BaseResponse createOrgUsers(@RequestBody List<String> userIds, @PathVariable String id) {
        service.saveOrUpdateOrgUsers(userIds, id);
        return BaseResponse.SUCCESS("保存成功");
    }

}
