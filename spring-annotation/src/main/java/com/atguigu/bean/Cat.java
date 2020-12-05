package com.atguigu.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wangsen@qgutech.com
 * @since 2019/6/8 14:13
 */
@Component
@Data
@Slf4j
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        log.info("Cat 初始化....");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Cat 销毁方法....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Cat 创建完成，属性复制完成后....初始化方法");
    }
}
