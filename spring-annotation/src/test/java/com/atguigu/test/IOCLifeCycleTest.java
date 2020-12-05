package com.atguigu.test;

import com.atguigu.config.BeanLiftCycleConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangsen@qgutech.com
 * @since 2019/6/7 22:46
 */
@Slf4j
public class IOCLifeCycleTest {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLiftCycleConfig.class);

    @Test
    public void test01() {
        log.info("容器初始化完成。。。。");
        context.close();
        log.info("容器关闭.....");
    }
}
