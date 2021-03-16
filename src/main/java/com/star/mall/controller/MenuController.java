package com.star.mall.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.base.query.Query;
import com.star.mall.persistence.entity.Menu;
import com.star.mall.persistence.service.IMenuService;
import com.star.mall.utils.TreeUtil;
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
public class MenuController extends BaseController<IMenuService, Menu> {

    @GetMapping("/tree")
    public List<Menu> menuTree() {
        List<Menu> menus = service.list();
        return TreeUtil.listToTree(menus);
    }

}
