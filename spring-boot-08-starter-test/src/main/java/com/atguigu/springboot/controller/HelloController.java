package com.atguigu.springboot.controller;

import com.atguigu.roxwangspringbootstarter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-10-31 23:19
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello("atguigu");
    }

}
