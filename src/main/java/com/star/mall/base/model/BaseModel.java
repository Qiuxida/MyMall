package com.star.mall.base.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础Model
 * @author StarQ
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 3699259628684168681L;

    @TableField("id_")
    @ApiModelProperty("实体ID")
    private String id;
    @TableField(value = "created_by_")
    @ApiModelProperty(value = "创建人ID")
    private String createdBy;
    @TableField(value = "created_time_", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;
    @TableField("updated_by_")
    @ApiModelProperty(value = "更新人ID")
    private String updatedBy;
    @TableField(value = "updated_time_", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedTime;
    @TableLogic
    @TableField(value = "deleted_", fill = FieldFill.INSERT, select = false)
    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleted;
    @Version
    @TableField(value = "version_", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "版本号")
    private Integer version;
}
