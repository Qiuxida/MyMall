package com.star.mall.persistence.service.impl;

import com.star.mall.persistence.entity.Menu;
import com.star.mall.persistence.mapper.MenuMapper;
import com.star.mall.persistence.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统菜单表  服务实现类
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
