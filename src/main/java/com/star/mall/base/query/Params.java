package com.star.mall.base.query;

import java.io.Serializable;
import java.util.List;

public class Params implements Serializable {
    private static final long serialVersionUID = -4719972515355059020L;

    private Relation relation;

    private List<Param> params;

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }
}
