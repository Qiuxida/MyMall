package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;

import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.star.mall.base.model.Tree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品类目 
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_category")
public class Category extends BaseModel implements Tree {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 类目名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 父ID
     */
    @TableField("PARENT_ID_")
    private String parentId;

    /**
     * 类目描述
     */
    @TableField("DESC_")
    private String desc;

    /**
     * 路径
     */
    @TableField("PATH_")
    private String path;

    /**
     * 类型
     */
    @TableField("TYPE_")
    private String type;

    /**
     * 子节点
     */
    @TableField(exist = false)
    private List<Category> children;

    @Override
    public String getPid() {
        return parentId;
    }

    @Override
    public List getChildren() {
        return children;
    }

    @Override
    public void setChildren(List list) {
        this.children = list;
    }

    @Override
    public Boolean isHead() {
        return "0".equals(parentId);
    }
}
