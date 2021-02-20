package com.star.mall.base.query;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.mall.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "query", description = "分页查询参数")
public class Query<T> implements Serializable {
    private static final long serialVersionUID = -2187346073476283340L;

    @ApiModelProperty(value = "查询字段数组", name = "query")
    private List<Param> query = new ArrayList<>();
    @ApiModelProperty(value = "分页参数", name = "page")
    private Page<T> page;
    @ApiModelProperty(value = "排序字段数组", name = "sorter")
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
        String field = BeanUtil.toLineString(param.getField())+"_";
        switch (param.getOperation()) {
            case EQUAL:
                wrapper.eq(field,param.getValue());
                break;
            case NOT_EQUAL:
                wrapper.ne(field,param.getValue());
                break;
            case IS_NULL:
                wrapper.isNull(field);
                break;
            case NOT_NULL:
                wrapper.isNotNull(field);
                break;
            case LESS_THAN:
                wrapper.le(field,param.getValue());
                break;
            case GREAT_THAN:
                wrapper.ge(field, param.getValue());
                break;
            case LEFT_LIKE:
                wrapper.likeLeft(field,param.getValue());
                break;
            case RIGHT_LIKE:
                wrapper.likeRight(field,param.getValue());
                break;
            case LIKE:
                wrapper.like(field,param.getValue());
                break;
            default:
                break;
        }
        if (ObjectUtil.isNotEmpty(param.getRelation()) && param.getRelation().equals(Relation.OR)) {
            wrapper.or();
        }
    }
}
