package com.star.mall.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.mall.persistence.entity.OperationLog;
import com.star.mall.persistence.mapper.OperationLogMapper;
import com.star.mall.persistence.service.IOperationLogService;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {
}
