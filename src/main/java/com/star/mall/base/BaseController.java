package com.star.mall.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.star.mall.base.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

public class BaseController<M extends IService<T>,T> {

    @Autowired
    protected M service;

    @GetMapping("/{id}")
    public T get(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("")
    public void create(@RequestBody T t) {
        service.save(t);
    }

    @PutMapping("")
    public void update(@RequestBody T t) {
        service.updateById(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.removeById(id);
    }

}
