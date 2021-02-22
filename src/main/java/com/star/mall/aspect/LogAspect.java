package com.star.mall.aspect;

import cn.hutool.json.JSONUtil;
import com.star.mall.persistence.entity.OperationLog;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志切面实现类
 * @author StarQ
 * @since 2021-01-23
 */
@Aspect
@Component
@Log4j2
public class LogAspect {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void operationLogCut() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.ExceptionHandler)")
    public void errorLogCut() {}

    @AfterReturning(pointcut = "operationLogCut()", returning = "keys")
    public void operationLog(JoinPoint joinPoint, Object keys) {
        RequestAttributes requestAttribute = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttribute).getRequest();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperation operation = method.getAnnotation(ApiOperation.class);

        OperationLog log = new OperationLog();
        log.setIp(request.getRemoteAddr());
        log.setNote(operation.notes());
        log.setType(operation.httpMethod());
        log.setUrl(request.getRequestURI());
        log.setRequest(request.getQueryString());

        kafkaTemplate.send("opr-log", JSONUtil.toJsonStr(log));
    }

    @AfterReturning(pointcut = "errorLogCut()", returning = "keys")
    public void errorLog(JoinPoint joinPoint, Object keys) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ExceptionHandler exception = method.getAnnotation(ExceptionHandler.class);
        log.info(exception.value());
        log.info(keys);
    }
}
