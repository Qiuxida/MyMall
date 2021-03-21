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
 * 品牌表 
 * </p>
 *
 * @author StarQ
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_brand")
@ApiModel(value = "品牌")
public class Brand extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌名称
     */
    @TableField("NAME_")
    @ApiModelProperty(value = "品牌名称", required = true)
    private String name;

    /**
     * 品牌简称
     */
    @TableField("SHORT_NAME_")
    @ApiModelProperty(value = "品牌简称")
    private String shortName;

    /**
     * 品牌图标
     */
    @TableField("ICON_")
    @ApiModelProperty(value = "品牌图标")
    private String icon;

    /**
     * 品牌介绍
     */
    @TableField("DESC_")
    @ApiModelProperty(value = "品牌介绍")
    private String desc;

}
