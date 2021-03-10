package com.star.mall.controller;

import com.star.mall.persistence.entity.User;
import com.star.mall.persistence.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.star.mall.base.BaseController;

/**
 * <p>
 *  用户
 * </p>
 *
 * @author StarQ
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/mall/user")
@Api("用户管理")
public class UserController extends BaseController<IUserService, User> {

}
