package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;

import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.star.mall.base.model.Tree;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统菜单表 
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class Menu extends BaseModel implements Tree {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单别名
     */
    @TableField("ALIAS_")
    @ApiModelProperty(value = "商品别名", required = true)
    private String alias;

    /**
     * 菜单名称
     */
    @TableField("NAME_")
    @ApiModelProperty(value = "商品名称", required = true)
    private String name;

    /**
     * 上级菜单ID
     */
    @TableField("PARENT_ID_")
    @ApiModelProperty(value = "上级菜单ID", required = true)
    private String parentId;

    /**
     * 上下级路径
     */
    @TableField("PATH_")
    @ApiModelProperty(value = "上下级路径")
    private String path;

    /**
     * 链接
     */
    @TableField("HREF_")
    @ApiModelProperty(value = "链接")
    private String href;

    /**
     * 图标
     */
    @TableField("ICON_")
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 是否启用
     */
    @TableField("ENABLED_")
    @ApiModelProperty(value = "是否启用")
    private Integer enabled;

    @TableField(exist = false)
    @ApiModelProperty(value = "子菜单")
    private List<Menu> children;


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
