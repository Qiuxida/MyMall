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
 * 用户角色关联表
 * </p>
 *
 * @author StarQ
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("uc_role_user")
public class RoleUser extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 用户ID
     */
    @TableField("USER_ID_")
    private String userId;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID_")
    private String roleId;

}
