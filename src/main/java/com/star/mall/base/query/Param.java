package com.star.mall.base.query;

import java.io.Serializable;

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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }
}
