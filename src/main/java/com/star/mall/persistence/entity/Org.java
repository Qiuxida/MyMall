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
 * 组织表 
 * </p>
 *
 * @author StarQ
 * @since 2021-01-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("uc_org")
@ApiModel(value = "组织")
public class Org extends BaseModel implements Tree {

    private static final long serialVersionUID = 1L;

    /**
     * 组织编码
     */
    @TableField("CODE_")
    @ApiModelProperty(value = "组织编码", required = true)
    private String code;

    /**
     * 组织名称
     */
    @TableField("NAME_")
    @ApiModelProperty(value = "组织名称", required = true)
    private String name;

    /**
     * 组织描述
     */
    @TableField("DESC_")
    @ApiModelProperty(value = "组织描述", required = true)
    private String desc;

    /**
     * 父组织ID
     */
    @TableField("PARENT_ID_")
    @ApiModelProperty(value = "父组织ID", required = true)
    private String parentId;

    /**
     * 组织路径
     */
    @TableField("PATH_")
    @ApiModelProperty(value = "组织路径")
    private String path;

    @TableField(exist = false)
    @ApiModelProperty(value = "子组织")
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
