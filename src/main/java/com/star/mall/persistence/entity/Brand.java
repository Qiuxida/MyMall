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
 * 品牌表 
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_brand")
public class Brand extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 品牌名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 品牌简称
     */
    @TableField("SHORT_NAME_")
    private String shortName;

    /**
     * 品牌图标
     */
    @TableField("ICON_")
    private String icon;

    /**
     * 品牌介绍
     */
    @TableField("DESC_")
    private String desc;

}
