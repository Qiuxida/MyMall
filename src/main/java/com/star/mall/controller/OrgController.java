package com.star.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.star.mall.base.query.Query;
import com.star.mall.base.response.BaseResponse;
import com.star.mall.persistence.entity.Org;
import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IOrgService;
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

    @GetMapping("/tree/{orgId}")
    public List<Org> getOrgTree(@PathVariable String orgId) throws Exception {
        return service.getOrgTree(orgId);
    }

    @PostMapping("/parent")
    public BaseResponse addByParentId(@RequestBody Org org) throws Exception {
        service.addByParentId(org);
        return BaseResponse.SUCCESS("保存成功");
    }

    @GetMapping("/users/page")
    public IPage<User> getUsersByCode(@RequestBody Query query) {
        return service.queryOrgUsers(query);
    }

}
