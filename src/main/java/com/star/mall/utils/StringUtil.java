package com.star.mall.utils;

/**
 * @program: mall
 * @description
 * @author: Sam
 * @version: 1.0
 * @create: 2021-04-16 23:14
 **/
public class StringUtil {
    /**
     * 字符串是否为空判断
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }
}
