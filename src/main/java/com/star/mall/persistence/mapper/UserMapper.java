package com.star.mall.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.mall.persistence.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getByUsername(@Param("username") String username);
}
