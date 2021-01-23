package com.star.mall.base.query;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.utils.BeanUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * 查询参数
 * @param <T>
 * @author StarQ
 * @since 2021-01-23
 */
@Data
public class Query<T> implements Serializable {
    private static final long serialVersionUID = -2187346073476283340L;

    private List<Param> query;

    private Page<T> page;

    private List<Sorter> sorter = new ArrayList<>();

    public QueryWrapper<T> toWrapper() {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        convertParam(query, wrapper);

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

    public void convertParam(List<Param> params, QueryWrapper<T> wrapper) {
        params.forEach(param -> {
            if (ArrayUtil.isNotEmpty(param.getParams())) {
                if (Relation.AND.equals(param.getRelation())) {
                    wrapper.and(item -> {
                        convertParam(param.getParams(), item);
                    });
                }else {
                    wrapper.or(item -> {
                        convertParam(param.getParams(), item);
                    });
                    wrapper.or();
                }
            }else {
                operate(param, wrapper);
            }
        });
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
            case LEFT_LIKE:
                wrapper.likeLeft(param.getField(),param.getValue());
                break;
            case RIGHT_LIKE:
                wrapper.likeRight(param.getField(),param.getValue());
                break;
            case LIKE:
                wrapper.like(param.getField(),param.getValue());
                break;
            default:
                break;
        }
        if (ObjectUtil.isNotEmpty(param.getRelation()) && param.getRelation().equals(Relation.OR)) {
            wrapper.or();
        }
    }
}
