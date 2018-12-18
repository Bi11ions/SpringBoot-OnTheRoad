package com.atguigu.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 16:28
 */
public class WindowsCondition implements Condition {
    /**
     *
     *  ConditionContext ： 判断条件能够使用的上下文（环境）
     *  AnnotatedTypeMetadata ： 注释信息
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 是否 windows 系统
        // 1. 能够获取到 beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2. 能够获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 能够获取到当前运行的环境信息
        Environment environment = context.getEnvironment();
        // 4. 获取到 bean 定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        // 判断容器中的 bean 注册情况
        boolean beanDefinition = registry.containsBeanDefinition("person");
        String osName = environment.getProperty("os.name");
        if (osName.contains("Windows")) {
            return true;
        }

        return false;
    }
}
