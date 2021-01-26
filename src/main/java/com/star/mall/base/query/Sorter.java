package com.star.mall.base.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 排序参数
 * @author StarQ
 * @since 2021-01-23
 */
@Data
@ApiModel(value = "Sorter", description = "排序参数")
public class Sorter implements Serializable {
    private static final long serialVersionUID = -1115872158897631892L;

    @ApiModelProperty(value = "字段", name = "field")
    private String field;
    @ApiModelProperty(value = "排序", name = "direction")
    private Direction direction;

}
