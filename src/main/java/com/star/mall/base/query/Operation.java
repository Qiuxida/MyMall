package com.star.mall.base.query;

/**
 * 运算符
 * @author StarQ
 * @since 2021-01-23
 */
public enum Operation {

    EQUAL("EQUAL"),
    NOT_EQUAL("NOT_EQUAL"),
    GREAT_THAN("GREAT_THAN"),
    LESS_THAN("LESS_THAN"),
    IS_NULL("IS_NULL"),
    NOT_NULL("NOT_NULL"),
    LEFT_LIKE("LEFT_LIKE"),
    RIGHT_LIKE("RIGHT_LIKE"),
    LIKE("LIKE");

    private String value;

    Operation(String value) {
        this.value = value;
    }
}
