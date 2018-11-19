package com.atguigu.springboot.config;

import com.atguigu.springboot.filter.MyFilter;
import com.atguigu.springboot.listener.MyListener;
import com.atguigu.springboot.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Arrays;

/**
 * @author wangsen
 * @createtime 2018-10-26 17:09
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册三大组件
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));

        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());

        return registrationBean;
    }

    /**
     * SpringBoot2.x 使用以下方式定制嵌入式Servlet容器
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8082);
        return factory;
    }
}
