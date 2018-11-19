package com.atguigu.springboot.config;

import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangsen
 * @create 2018-09-02 16:13
 */
@Configuration
public class MyMvcConfig2 implements WebMvcConfigurer {




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        // 防止表单的重复提交
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /** 拦截任意路径下任意请求, Spring Boot 2.0 以上版本会拦截静态资源，需要把静态资源所在目录也排除在外
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/",  "/user/login", "/asserts/**", "favicon.ico", "/webjars/**");
    }

    @Bean(name="localeResolver")
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
