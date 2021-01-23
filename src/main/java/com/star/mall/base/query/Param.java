package com.star.mall.base.query;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询参数
 * @author StarQ
 * @since 2021-01-23
 */
@Data
public class Param implements Serializable {
    private static final long serialVersionUID = -6836367180195136378L;

    //字段名称
    private String field;
    //字段值
    private String value;
    //操作符
    private Operation operation;
    //联系
    private Relation relation;
    //子级参数
    private List<Param> params;

}
