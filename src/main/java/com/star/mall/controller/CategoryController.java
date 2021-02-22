package com.star.mall.controller;


import com.star.mall.persistence.entity.Category;
import com.star.mall.persistence.service.ICategoryService;
import com.star.mall.utils.TreeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.star.mall.base.BaseController;

import java.util.List;

/**
 * <p>
 * 商品类目  前端控制器
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/mall/category")
public class CategoryController extends BaseController<ICategoryService, Category> {

    @GetMapping("/tree")
    public List<Category> categoriesTree() {
        List<Category> categories = service.list();
        return TreeUtil.listToTree(categories);
    }
}
