package com.atguigu.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wangsen@qgutech.com
 * @since 2019/6/8 14:21
 */
@Component
@Data
@Slf4j
public class Dog {
    public Dog() {
        log.info("Dog 构造器方法....");
    }

    @PostConstruct
    public void init() {
        log.info("Dog 初始化方法.....");
    }

    @PreDestroy
    public void destroy() {
        log.info("Dog 销毁方法....");
    }
}
