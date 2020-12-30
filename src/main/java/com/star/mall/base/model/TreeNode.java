package com.star.mall.base.model;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
public class TreeNode implements Tree{

    private String id;

    private String parentId;

    private String name;

    @Setter(AccessLevel.NONE)
    private List<TreeNode> children;

    @Override
    public String getPid() {
        return parentId;
    }

    @Override
    public Boolean isHead() {
        return "0".equals(id);
    }

    @Override
    public List getChildren() {
        return children;
    }

    @Override
    public void setChildren(List list) {
        this.children = list;
    }
}
