package com.star.mall.base.query;

import lombok.Data;

import java.io.Serializable;

/**
 * 排序参数
 * @author StarQ
 * @since 2021-01-23
 */
@Data
public class Sorter implements Serializable {
    private static final long serialVersionUID = -1115872158897631892L;

    private String field;
    private Direction direction;

}
