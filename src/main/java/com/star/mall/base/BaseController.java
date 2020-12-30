package com.star.mall.base;

import com.baomidou.mybatisplus.extension.service.IService;
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
    public T get(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("")
    public void create(@RequestBody T t) {
        if (service.save(t)){
            throw new RuntimeException("创建失败");
        }
    }

    @PutMapping("")
    public void update(@RequestBody T t) {
        if (!service.updateById(t)) {
            throw new RuntimeException("更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.removeById(id);
    }

}
