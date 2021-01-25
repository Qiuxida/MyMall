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
 * 组织用户表 
 * </p>
 *
 * @author StarQ
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("uc_org_user")
public class OrgUser extends BaseModel {

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
     * 组织ID
     */
    @TableField("ORG_ID_")
    private String orgId;


}
