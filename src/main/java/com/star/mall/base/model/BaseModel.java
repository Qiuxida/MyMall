package com.star.mall.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础Model
 * @author 邱喜达
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 3699259628684168681L;

    @TableField(value = "created_by_")
    private String createdBy;
    @TableField(value = "created_time_", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableField("updated_by_")
    private String updatedBy;
    @TableField(value = "updated_time_", fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;
    @TableLogic
    @TableField(value = "deleted_", fill = FieldFill.INSERT)
    private Integer deleted;
    @Version
    @TableField("version_")
    private Integer version;
}
