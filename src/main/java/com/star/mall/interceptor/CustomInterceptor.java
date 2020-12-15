package com.star.mall.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({@Signature(type = Executor.class,method = "query",args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })})
public class CustomInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Executor excutor = (Executor) invocation.getTarget();
        System.out.println(invocation);
        return null;
    }
}
