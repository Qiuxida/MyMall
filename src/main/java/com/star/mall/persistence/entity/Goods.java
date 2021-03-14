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
 * 商品表 
 * </p>
 *
 * @author StarQ
 * @since 2021-03-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mall_goods")
public class Goods extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 商品码
     */
    @TableField("CODE_")
    private String code;

    /**
     * 商品名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 商品图片
     */
    @TableField("IMAGE_")
    private String image;

    /**
     * 类目ID
     */
    @TableField("CATEGORY_ID_")
    private String categoryId;

    /**
     * 品牌ID
     */
    @TableField("BRAND_ID_")
    private String brandId;

    /**
     * 商品描述
     */
    @TableField("DESC_")
    private String desc;

    /**
     * 是否上架
     */
    @TableField("IS_SALE_")
    private Integer isSale;

    /**
     * 乐观锁
     */
    @TableField("VERSION_")
    private Integer version;

    /**
     * 创建人
     */
    @TableField("CREATED_BY_")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME_")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY_")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME_")
    private LocalDateTime updatedTime;


}
