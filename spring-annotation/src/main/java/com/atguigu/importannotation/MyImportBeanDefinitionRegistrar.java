package com.atguigu.importannotation;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 17:12
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata : 当前类的注解相关的信息
     * BeanDefinitionRegistry ： 所有需要添加到容器中的 bean，使用 BeanDefinitionRegistry.registerBeanDefinition 这个方法
     * 手动将 bean 注册到容器中
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean existRed = registry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean existGreen = registry.containsBeanDefinition("com.atguigu.bean.Green");
        if (existGreen && existRed) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
