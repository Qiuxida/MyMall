package com.star.mall.utils;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;

public class UniqueIdUtil {

    @Value("${system.id.workerId:1}")
    private static Long workerId;
    @Value("${system.id.datacenterId:1}")
    private static Long datacenterId;

    public static final String getSid() {
        return IdUtil.getSnowflake(workerId, datacenterId).nextIdStr();
    }

    public static final Long getId() {
        return IdUtil.getSnowflake(workerId, datacenterId).nextId();
    }
}
