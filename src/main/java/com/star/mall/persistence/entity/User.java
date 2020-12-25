package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.star.mall.base.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  管理用户
 * </p>
 *
 * @author 邱喜达
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("uc_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id_")
    private String id;

    @TableField("account_")
    private String account;

    @TableField("name_")
    private String name;

    @TableField("password_")
    private String password;

    @TableField("deleted_")
    private Short deleted;

}
