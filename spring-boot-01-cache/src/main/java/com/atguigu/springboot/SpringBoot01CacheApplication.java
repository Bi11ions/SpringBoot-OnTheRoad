package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// 开启缓存时需要在主类上声明开启缓存注解
@EnableCaching
@MapperScan(basePackages = "com.atguigu.springboot.mapper")
@SpringBootApplication
public class SpringBoot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }
}
