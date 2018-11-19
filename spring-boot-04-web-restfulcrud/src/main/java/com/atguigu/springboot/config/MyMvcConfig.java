package com.atguigu.springboot.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Spring Boot2.0 对 SpringMVC 拓展的方式与之前版本不一样，可以用继承 WebMvcConfigurationSupport，
 *      或者实现 WebMvcConfigurer 接口。
 * 但是继承 WebMvcConfigurationSupport 之后，由于 Spring Boot2.0 搭载 Spring5.x 所以会自动拦截所有静态资源
 * 推荐使用实现  WebMvcConfigurer 接口，不会拦截静态资源,参照 MyMvcConfig2.class
 * @author wangsen
 * @create 2018-09-02 15:54
 */
// 使用时需要打开该注解，使其加入 Spring 容器中
//@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }
}
