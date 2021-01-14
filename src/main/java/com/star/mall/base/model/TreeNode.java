package com.star.mall.base.model;

import com.star.mall.annotations.ConvertProperty;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
public class TreeNode implements Tree{

    @ConvertProperty(field = "id1")
    private String id;
    @ConvertProperty(field = "parentId")
    private String parentId;
    @ConvertProperty(field = "name")
    private String name;
    @ConvertProperty(field = "id")
    private Integer integer;

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
