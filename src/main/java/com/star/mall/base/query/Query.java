package com.star.mall.base.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query<T> implements Serializable {
    private static final long serialVersionUID = -2187346073476283340L;

    private Map<String, List<Param>> query = new HashMap<>();

    private Page<T> page;

    private List<Sorter> sorter = new ArrayList<>();

    public Map<String, List<Param>> getQuery() {
        return query;
    }

    public void setQuery(Map<String, List<Param>> query) {
        this.query = query;
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public List<Sorter> getSorter() {
        return sorter;
    }

    public void setSorter(List<Sorter> sorter) {
        this.sorter = sorter;
    }

    public QueryWrapper<T> convert2Wrapper() {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        query.forEach((key, value) -> {
            value.forEach(param -> operate(param,wrapper));
        });
        sorter.forEach(item -> {
            if (Direction.DESC.equals(item.getDirection())) {
                wrapper.orderByDesc(item.getField());
            }else if (Direction.ASC.equals(item.getDirection())){
                wrapper.orderByAsc(item.getField());
            }else {
                throw new RuntimeException("排序符号不存在");
            }
        });
        return wrapper;
    }

    public void operate(Param param, QueryWrapper<T> wrapper) {
        switch (param.getOperation()) {
            case EQUAL:
                wrapper.eq(param.getField(),param.getValue());
                break;
            case NOT_EQUAL:
                wrapper.ne(param.getField(),param.getValue());
                break;
            case IS_NULL:
                wrapper.isNull(param.getField());
                break;
            case NOT_NULL:
                wrapper.isNotNull(param.getField());
                break;
            case LESS_THAN:
                wrapper.le(param.getField(),param.getValue());
                break;
            case GREAT_THAN:
                wrapper.ge(param.getField(), param.getValue());
                break;
            default:
                break;
        }
        if (param.getRelation().equals(Relation.OR)) {
            wrapper.or();
        }
    }
}
