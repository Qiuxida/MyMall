package com.star.mall.base.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询参数
 * @author StarQ
 * @since 2021-01-23
 */
@Data
@ApiModel(value = "Param", description = "分页查询参数")
public class Param implements Serializable {
    private static final long serialVersionUID = -6836367180195136378L;

    @ApiModelProperty(value = "字段名称", name = "field")
    private String field;
    @ApiModelProperty(value = "字段值", name = "value")
    private String value;
    @ApiModelProperty(value = "操作符", name = "operation")
    private Operation operation;
    @ApiModelProperty(value = "关联管理", name = "relation")
    private Relation relation;
    @ApiModelProperty(value = "子级参数", name = "params")
    private List<Param> params;

}
