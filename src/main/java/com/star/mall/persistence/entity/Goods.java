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
 * 商品表 
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_goods")
@ApiModel(value = "商品")
public class Goods extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 商品码
     */
    @TableField("CODE_")
    @ApiModelProperty(value = "商品码", required = true)
    private String code;

    /**
     * 商品名称
     */
    @TableField("NAME_")
    @ApiModelProperty(value = "商品名称", required = true)
    private String name;

    /**
     * 商品图片
     */
    @TableField("IMAGE_")
    @ApiModelProperty(value = "商品图片")
    private String image;

    /**
     * 类目ID
     */
    @TableField("CATEGORY_ID_")
    @ApiModelProperty(value = "类目ID")
    private String categoryId;

    /**
     * 品牌ID
     */
    @TableField("BRAND_ID_")
    @ApiModelProperty(value = "品牌ID")
    private String brandId;

    /**
     * 商品描述
     */
    @TableField("DESC_")
    @ApiModelProperty(value = "商品描述")
    private String desc;

    /**
     * 是否上架
     */
    @TableField("IS_SALE_")
    @ApiModelProperty(value = "是否上架")
    private Integer isSale;

}
