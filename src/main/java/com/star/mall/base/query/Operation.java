package com.star.mall.base.query;

public enum Operation {

    EQUAL("EQUAL"),
    NOT_EQUAL("NOT_EQUAL"),
    GREAT_THAN("GREAT_THAN"),
    LESS_THAN("LESS_THAN"),
    IS_NULL("IS_NULL"),
    NOT_NULL("NOT_NULL");

    private String value;
    Operation(String value) {
        this.value = value;
    }
}
