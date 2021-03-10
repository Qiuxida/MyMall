package com.star.mall.utils;

import com.star.mall.generator.CustomIdGenerator;

/**
 * Id工具类
 * @author StarQ
 * @since 2021-2-20
 */
public class UniqueIdUtil {

    private static CustomIdGenerator customIdGenerator;

    static {
        customIdGenerator = ApplicationContextUtil.getBean(CustomIdGenerator.class);
    }

    public static final String getSid() {
        return customIdGenerator.nextIdStr();
    }

    public static final Long getId() {
        return customIdGenerator.nextId(null);
    }
}
