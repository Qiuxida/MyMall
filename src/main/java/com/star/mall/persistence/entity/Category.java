package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;

import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.star.mall.base.model.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "商品类目")
public class Category extends BaseModel implements Tree {

    private static final long serialVersionUID = 1L;

    /**
     * 类目名称
     */
    @TableField("NAME_")
    @ApiModelProperty(value = "类目名称", required = true)
    private String name;

    /**
     * 父ID
     */
    @TableField("PARENT_ID_")
    @ApiModelProperty(value = "上级类目ID", required = true)
    private String parentId;

    /**
     * 类目描述
     */
    @TableField("DESC_")
    @ApiModelProperty(value = "类目描述")
    private String desc;

    /**
     * 路径
     */
    @TableField("PATH_")
    @ApiModelProperty(value = "路径")
    private String path;

    /**
     * 类型
     */
    @TableField("TYPE_")
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 子节点
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "子节点")
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
