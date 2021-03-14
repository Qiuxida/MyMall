package com.star.mall.persistence.service.impl;

import com.star.mall.persistence.entity.Goods;
import com.star.mall.persistence.mapper.GoodsMapper;
import com.star.mall.persistence.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表  服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
