package com.atguigu.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangsen@qgutech.com
 * @since 2019/6/7 22:42
 */
@Data
@Slf4j
public class Car {
    public Car() {
        log.info("car constructor...");
    }

    public void init() {
        log.info("car ... init...");
    }

    public void destroy() {
        log.info("car ... destroy...");
    }
}
