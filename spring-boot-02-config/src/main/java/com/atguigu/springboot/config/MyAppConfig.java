package com.atguigu.springboot.config;

/**
 * @author wangsen
 * @create 2018-08-30 10:14
 */

import com.atguigu.springboot.sevice.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 指定当前类是一个配置类，相当于之前 Spring 的配置文件
 * 在配置文件中使用 <bean></bean> 标签来添加组件
 *
 * 而在配置类中使用 @Bean 来添加组件
 */
@Configuration
public class MyAppConfig {

    // 将方法的返回值返回给容器中，容器中这个组件默认的 id 就是这个方法名
    @Bean
    public HelloService helloService() {
        System.out.println("配置类向容器中添加 Bean ...");
        return new HelloService();
    }

}
