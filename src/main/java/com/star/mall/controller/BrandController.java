package com.star.mall.controller;


import com.star.mall.persistence.entity.Brand;
import com.star.mall.persistence.service.IBrandService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.star.mall.base.BaseController;

/**
 * <p>
 * 品牌表  前端控制器
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/mall/brand")
public class BrandController extends BaseController<IBrandService, Brand> {

}
