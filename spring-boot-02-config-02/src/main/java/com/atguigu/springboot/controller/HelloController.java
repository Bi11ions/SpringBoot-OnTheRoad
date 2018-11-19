package com.atguigu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @create 2018-08-30 14:40
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello!";
    }

}
