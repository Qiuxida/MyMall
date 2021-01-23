package com.star.mall.base.query;

/**
 * 关联关系
 * @author StarQ
 * @since 2021-01-23
 */
public enum Relation {

    AND("AND"),

    OR("OR");

    private String value;

    Relation(String value) {
        this.value = value;
    }
}
