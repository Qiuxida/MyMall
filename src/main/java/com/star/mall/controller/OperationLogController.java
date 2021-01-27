package com.star.mall.controller;

import com.star.mall.persistence.entity.OperationLog;
import com.star.mall.persistence.service.IOperationLogService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.star.mall.base.BaseController;

/**
 * <p>
 * 操作日志  前端控制器
 * </p>
 *
 * @author StarQ
 * @since 2021-01-27
 */
@RestController
@RequestMapping("/mall/log/operation")
public class OperationLogController extends BaseController<IOperationLogService, OperationLog> {

}
