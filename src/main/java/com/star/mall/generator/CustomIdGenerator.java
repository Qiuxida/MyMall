package com.star.mall.generator;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Value;

public class CustomIdGenerator implements IdentifierGenerator {

    @Value("${system.id.workerId:1}")
    private Long workerId;
    @Value("${system.id.datacenterId:1}")
    private Long datacenterId;

    @Override
    public Long nextId(Object entity) {
        Snowflake snowflake = IdUtil.getSnowflake(workerId,datacenterId);
        return snowflake.nextId();
    }

}
