package com.star.mall.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.star.mall.base.query.Query;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void create(@ApiParam (name = "t", value = "新增实体对象", required = true)@RequestBody T t) {
        if (service.save(t)){
            throw new RuntimeException("创建失败");
        }
    }

    @PutMapping("")
    @ApiOperation(value = "根据ID更新实体", httpMethod = "GET", notes = "根据ID更新实体")
    public void update(@ApiParam(name = "t", value = "更新实体对象", required = true) @RequestBody T t) {
        if (!service.updateById(t)) {
            throw new RuntimeException("更新失败");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除实体", httpMethod = "GET", notes = "根据ID删除实体")
    public void delete(@ApiParam(name = "id", value = "实体ID", required = true)@PathVariable String id) {
        service.removeById(id);
    }

    @PostMapping("/page")
    @ApiOperation(value = "根据分页条件获取实体列表", httpMethod = "POST", notes = "根据分页条件获取实体列表")
    public Page<T> page(@ApiParam(name = "query", value = "查询对象", required = true) @RequestBody Query query) {
        return service.page(query.getPage(), query.toWrapper());
    }

}
