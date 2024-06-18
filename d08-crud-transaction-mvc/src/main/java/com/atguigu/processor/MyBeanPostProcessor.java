package com.atguigu.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 包名:com.atguigu.processor
 *
 * @author Leevi
 * 日期2023-05-04  14:17
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor的postProcessBeforeInitialization方法执行了...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor的postProcessAfterInitialization方法执行了...");
        return bean;
    }
}
