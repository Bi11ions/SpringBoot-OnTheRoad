package com.atguigu.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wangsen
 * @createtime 2018-10-30 17:18
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer.....initialize....."+applicationContext);
    }
}
