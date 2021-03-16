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
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 别名
     */
    @TableField("ALIAS_")
    private String alias;

    /**
     * 名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 上级ID
     */
    @TableField("PARENT_ID_")
    private String parentId;

    /**
     * 上下级路径
     */
    @TableField("PATH_")
    private String path;

    /**
     * 链接
     */
    @TableField("HREF_")
    private String href;

    /**
     * 图标
     */
    @TableField("ICON_")
    private String icon;

    /**
     * 是否启用
     */
    @TableField("ENABLED_")
    private Integer enabled;

    @TableField(exist = false)
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
