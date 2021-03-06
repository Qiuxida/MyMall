package com.star.mall.controller;

import com.star.mall.persistence.entity.Goods;
import com.star.mall.persistence.service.IGoodsService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.star.mall.base.BaseController;

/**
 * <p>
 * 商品表  前端控制器
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@RestController
@RequestMapping("/mall/goods")
@Api(value = "商品管理", tags = {"商品管理"})
public class GoodsController extends BaseController<IGoodsService, Goods> {

}
