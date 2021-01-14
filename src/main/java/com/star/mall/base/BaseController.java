package com.star.mall.base;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础controller，添加默认接口
 * @author qiuxd
 */
public class BaseController<M extends IService<T>,T> {

    @Autowired
    protected M service;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取实体", httpMethod = "GET", notes = "根据ID获取实体")
    public T get(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("")
    @ApiOperation(value = "根据ID创建实体", httpMethod = "POST", notes = "根据ID创建实体")
    public void create(@RequestBody T t) {
        if (service.save(t)){
            throw new RuntimeException("创建失败");
        }
    }

    @PutMapping("")
    @ApiOperation(value = "根据ID更新实体", httpMethod = "GET", notes = "根据ID更新实体")
    public void update(@RequestBody T t) {
        if (!service.updateById(t)) {
            throw new RuntimeException("更新失败");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除实体", httpMethod = "GET", notes = "根据ID删除实体")
    public void delete(@PathVariable String id) {
        service.removeById(id);
    }

}
