package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  角色
 * </p>
 *
 * @author StarQ
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("uc_role")
@ApiModel("角色")
public class Role extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码
     */
    @TableField("CODE_")
    @ApiModelProperty(value = "角色编码", required = true)
    private String code;

    /**
     * 角色名称
     */
    @TableField("NAME_")
    @ApiModelProperty(value = "角色名称", required = true)
    private String name;

    /**
     * 角色描述
     */
    @TableField("DESC_")
    @ApiModelProperty(value = "角色描述")
    private String desc;

}
