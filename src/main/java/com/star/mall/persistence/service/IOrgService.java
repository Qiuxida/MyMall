package com.star.mall.persistence.service;

import com.star.mall.persistence.entity.Org;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织表  服务类
 * </p>
 *
 * @author 邱喜达
 * @since 2021-01-17
 */
public interface IOrgService extends IService<Org> {

    List<Org> getOrgTree(String orgId);

    void addByParentId(Org org);
}
