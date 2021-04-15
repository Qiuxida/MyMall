package com.star.mall.service;

/**
 * 登录认证
 * @author StarQ
 * @since 2021-04-16
 */
public interface AuthService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);
}
