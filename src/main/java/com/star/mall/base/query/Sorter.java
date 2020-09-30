package com.star.mall.base.query;

import java.io.Serializable;

public class Sorter implements Serializable {
    private static final long serialVersionUID = -1115872158897631892L;

    private String field;
    private Direction direction;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
