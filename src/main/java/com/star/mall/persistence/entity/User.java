package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.star.mall.base.model.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 *  管理用户
 * </p>
 *
 * @author StarQ
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@TableName("uc_user")
@ApiModel("用户")
public class User extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("account_")
    @ApiModelProperty(value = "用户账号", required = true)
    private String account;

    @TableField("name_")
    @ApiModelProperty(value = "用户姓名", required = true)
    private String name;

    @TableField("password_")
    @ApiModelProperty(value = "用户密码", required = true)
    private String password;

    @TableField("phone_")
    @ApiModelProperty(value = "用户电话")
    private String phone;

    @TableField("email_")
    @ApiModelProperty(value = "用户电子邮箱")
    private String email;

}
