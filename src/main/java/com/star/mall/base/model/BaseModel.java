package com.star.mall.base.model;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField("create_by_")
    private String createBy;
    @TableField("create_time_")
    private LocalDateTime createTime;
    @TableField("update_by_")
    private String updateBy;
    @TableField("update_time_")
    private LocalDateTime updateTime;
    @TableField("deleted_")
    private Integer deleted;

}
