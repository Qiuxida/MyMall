package com.star.mall.base;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<M extends IService<T>,T extends BaseModel> {

    @Autowired
    M manager;

    @GetMapping("/{id}")
    public T get(@PathVariable String id) {
        return manager.getById(id);
    }

    @PostMapping("")
    public void create(@RequestBody T t) {
        manager.save(t);
    }

    @PutMapping("")
    public void update(@RequestBody T t) {
        manager.updateById(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        manager.removeById(id);
    }
}
