package com.star.mall.controller;


import com.star.mall.persistence.entity.Org;
import com.star.mall.persistence.service.IOrgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
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
}
