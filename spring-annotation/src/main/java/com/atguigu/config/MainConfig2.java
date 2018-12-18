package com.atguigu.config;

import com.atguigu.bean.*;
import com.atguigu.conditional.LinuxCondition;
import com.atguigu.conditional.WindowsCondition;
import com.atguigu.importannotation.MyImportBeanDefinitionRegistrar;
import com.atguigu.importannotation.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 15:24
 */
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * "@Scope" : 指定作用域
     *      ConfigurableBeanFactory#SCOPE_PROTOTYPE
     *      ConfigurableBeanFactory#SCOPE_SINGLETON
     *      org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     *      org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     *      prototype 多实例的 : 在 IOC 容器初始化过程中不会创建对象。只有在获取时，才会创建对象
     *      singleton 单实例的 (default) : IOC 容器启动会调用方法创建对象到 IOC 容器中，以后每次获取，直接从容器中获取。
     *      request 同一次请求创建一个实例
     *      session 同一个 session 创建一个实例
     *
     *  懒加载：
     *      单实例 bean：默认在容器启动时创建对象，
     *      懒加载：容器启动时不创建对象，在第一次使用(获取) Bean 时才创建对象，并初始化。
     */
//    @Scope
    @Lazy
    @Bean
    public Person person() {
        System.out.println("加载 Person.....");
        return new Person("testing", 1);
    }

    /**
     * "@Conditional" = {Condition} : 按照一定条件进行判断，满足条件则向容器中注册 bean
     */
    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person01 () {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02 () {
        return new Person("linus", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}