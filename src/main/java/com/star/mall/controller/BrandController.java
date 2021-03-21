package com.star.mall.controller;

import com.star.mall.persistence.entity.Brand;
import com.star.mall.persistence.service.IBrandService;
import io.swagger.annotations.Api;
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
@Api(value = "品牌管理", tags = {"品牌管理"})
public class BrandController extends BaseController<IBrandService, Brand> {

}
