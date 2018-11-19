package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.lang.model.SourceVersion;

/**
 * @author wangsen
 * @create 2018-08-28 22:29
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }


}
