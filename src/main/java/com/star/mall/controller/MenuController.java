package com.star.mall.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.base.query.Query;
import com.star.mall.persistence.entity.Menu;
import com.star.mall.persistence.service.IMenuService;
import com.star.mall.utils.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.star.mall.base.BaseController;

import java.util.List;

/**
 * <p>
 * 系统菜单表  前端控制器
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@RestController
@RequestMapping("/mall/menu")
@Api(value = "系统菜单", tags = {"系统菜单"})
public class MenuController extends BaseController<IMenuService, Menu> {

    @GetMapping("/tree")
    @ApiOperation(value = "获取系统菜单树", notes = "获取系统菜单树", httpMethod = "GET")
    public List<Menu> menuTree() {
        List<Menu> menus = service.list();
        return TreeUtil.listToTree(menus);
    }

}
