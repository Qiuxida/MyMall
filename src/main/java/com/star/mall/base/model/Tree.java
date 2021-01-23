package com.star.mall.base.model;

import java.util.List;

/**
 * 树形数据接口，实现类list可转为树形结构
 * @author StarQ
 * @since 2021-01-23
 */
public interface Tree {

    /**
     * 获取主键ID
     * @return 主键ID
     */
    String getId();

    /**
     * 获取父级ID
     * @return 父级ID
     */
    String getPid();

    /**
     * 获取子元素
     * @return 子元素
     */
    List<Tree> getChildren();

    /**
     * 设置子元素
     * @param list 子元素
     */
    void setChildren(List<Tree> list);

    /**
     * 判断是否头节点
     * @return 是否头节点
     */
    Boolean isHead();
}
