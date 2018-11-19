package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangsen
 * @create 2018-08-28 22:22
 */

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个 SpringBoot 应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        // Spring 应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class, args);

    }

}
