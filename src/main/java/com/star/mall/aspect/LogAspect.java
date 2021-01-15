package com.star.mall.aspect;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void operationLogCut() {}

    @AfterReturning(pointcut = "operationLogCut()", returning = "keys")
    public void saveLog(JoinPoint joinPoint, Object keys) {
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttribute;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperation operation = method.getAnnotation(ApiOperation.class);
    }
}
