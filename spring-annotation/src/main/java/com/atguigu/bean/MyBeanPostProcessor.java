package com.atguigu.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器
 *
 * @author wangsen@qgutech.com
 * @since 2019/6/8 14:28
 */
@Component
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("后置处理器在Bean初始化执行前....:{}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("后置处理器在Bean初始化之后，初始化方法执行之前...:{}", beanName);
        return bean;
    }
}
