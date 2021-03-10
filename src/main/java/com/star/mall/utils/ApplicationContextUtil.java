package com.star.mall.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文
 * @author StarQ
 * @since 2021-03-10
 */
@Component
@Log4j2
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

    public static Object getBean(String name) {
        try {
            return context.getBean(name);
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

}
