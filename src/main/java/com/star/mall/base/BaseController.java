package com.star.mall.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.star.mall.base.query.Query;
import com.star.mall.base.response.BaseResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 基础controller，添加默认接口
 * @author StarQ
 * @since 2021-01-23
 */
public class BaseController<M extends IService<T>,T> {

    @Autowired
    protected M service;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取实体", httpMethod = "GET", notes = "根据ID获取实体")
    public T get(@ApiParam(name = "id", value = "实体ID", required = true) @PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("")
    @ApiOperation(value = "根据ID创建实体", httpMethod = "POST", notes = "根据ID创建实体")
    public BaseResponse<T> create(@ApiParam (name = "model", value = "新增实体对象", required = true)@RequestBody T t) {
        if (!service.save(t)){
            throw new RuntimeException("创建失败");
        }
        return BaseResponse.SUCCESS("创建成功");
    }

    @PutMapping("")
    @ApiOperation(value = "根据ID更新实体", httpMethod = "PUT", notes = "根据ID更新实体")
    public BaseResponse<T> update(@ApiParam(name = "model", value = "更新实体对象", required = true) @RequestBody T t) {
        if (!service.updateById(t)) {
            throw new RuntimeException("更新失败");
        }
        return BaseResponse.SUCCESS("更新成功");
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ID删除实体", httpMethod = "DELETE", notes = "根据ID删除实体")
    public BaseResponse<T> delete(@ApiParam(name = "ids", value = "实体ID集，用,分隔", required = true)@PathVariable String ...ids) {
        if (service.removeByIds(Arrays.asList(ids))) {
            throw new RuntimeException("删除失败");
        }
        return BaseResponse.SUCCESS("删除成功");
    }

    @PostMapping("/page")
    @ApiOperation(value = "根据分页条件获取实体列表", httpMethod = "POST", notes = "根据分页条件获取实体列表")
    public Page<T> page(@ApiParam(name = "query", value = "查询对象", required = true) @RequestBody Query<T> query) {
        return service.page(query.getPage(), query.toWrapper());
    }

}
