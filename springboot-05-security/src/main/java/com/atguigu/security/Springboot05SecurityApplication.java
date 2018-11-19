package com.atguigu.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入 Spring-Security 模块
 * 2.编写配置类
 *  @EnableWebSecurity
 *  public class MySecurityConfig extends WebSecurityConfigurerAdapter {
 *
 *  }
 */
@SpringBootApplication
public class Springboot05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05SecurityApplication.class, args);
    }
}
