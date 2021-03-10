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
 * 组织表 
 * </p>
 *
 * @author StarQ
 * @since 2021-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("uc_org")
public class Org extends BaseModel implements Tree {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 编码
     */
    @TableField("CODE_")
    private String code;

    /**
     * 名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 描述
     */
    @TableField("DESC_")
    private String desc;

    /**
     * 父组织ID
     */
    @TableField("PARENT_ID_")
    private String parentId;

    /**
     * 路径
     */
    @TableField("PATH_")
    private String path;

    @TableField(exist = false)
    private List<Org> children;

    @Override
    public String getPid() {
        return parentId;
    }

    @Override
    public List getChildren() {
        return children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    @Override
    public Boolean isHead() {
        return "0".equals(parentId);
    }
}
