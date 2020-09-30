package com.star.mall.base.query;

public enum Relation {
    AND("AND"),
    OR("OR");

    private String value;
    Relation(String value) {
        this.value = value;
    }
}
