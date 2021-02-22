package com.star.mall.persistence.service.impl;

import com.star.mall.persistence.entity.Category;
import com.star.mall.persistence.mapper.CategoryMapper;
import com.star.mall.persistence.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目  服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
