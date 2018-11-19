package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @create 2018-08-29 22:06
 */
@RestController
public class HelloController {

    @Value("#{person.lastName}")
    private String name;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello " + name;
    }

}
