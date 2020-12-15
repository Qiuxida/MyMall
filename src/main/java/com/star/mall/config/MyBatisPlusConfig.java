package com.star.mall.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.star.mall.generator.CustomIdGenerator;
import com.star.mall.interceptor.CustomInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(value = {PaginationInterceptor.class})
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize());
        return paginationInterceptor;
    }

    @Bean
    public IdentifierGenerator identifierGenerator() {
        return new CustomIdGenerator();
    }

    @Bean
    public CustomInterceptor customInterceptor() {
        CustomInterceptor customInterceptor = new CustomInterceptor();
        return customInterceptor;
    }
}
