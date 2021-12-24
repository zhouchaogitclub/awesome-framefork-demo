package com.zc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring容器上下文工具
 *
 * @author yeyu
 * @since 2021/11/27 4:07 下午
 */
@Component
@Slf4j
public final class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    public static <T> T getBean(String tClass) {
        return (T) context.getBean(tClass);
    }
}
