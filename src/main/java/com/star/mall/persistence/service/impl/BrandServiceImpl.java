package com.star.mall.persistence.service.impl;

import com.star.mall.persistence.entity.Brand;
import com.star.mall.persistence.mapper.BrandMapper;
import com.star.mall.persistence.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表  服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
