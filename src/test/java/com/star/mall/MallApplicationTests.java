package com.star.mall;

import com.star.mall.persistence.manager.UserManager;
import com.star.mall.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MallApplicationTests {

    @Resource
    UserManager userManager;

    @Test
    void contextLoads() {
        List<User> users = userManager.getByUsername("qiuxida");
        Assert.notEmpty(users,"不为空");
    }

}
