package com.star.mall.base.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sorter implements Serializable {
    private static final long serialVersionUID = -1115872158897631892L;

    private String field;
    private Direction direction;

}
