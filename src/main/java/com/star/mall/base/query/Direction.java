package com.star.mall.base.query;

/**
 * 排序
 * @author StarQ
 * @since 2021-01-23
 */
public enum Direction {

    ASC("ASC"),

    DESC("DESC");

    private String value;

    Direction(String value) {
        this.value = value;
    }
}
