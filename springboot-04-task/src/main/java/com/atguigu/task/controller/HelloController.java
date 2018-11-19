package com.atguigu.task.controller;

import com.atguigu.task.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-11-08 15:31
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @RequestMapping("hello")
    public String sayHello() {
        helloService.sayHello();

        return "success";
    }

}
