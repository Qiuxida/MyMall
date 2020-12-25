package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("uc_role")
public class Role extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 角色编码
     */
    @TableField("CODE_")
    private String code;

    /**
     * 角色名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 角色描述
     */
    @TableField("DESC_")
    private String desc;

    /**
     * 是否启用
     */
    @TableField("ENABLED_")
    private Integer enabled;

}
