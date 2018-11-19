package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @create 2018-08-29 20:06
 */
// 这个类所有方法返回的数据直接写给浏览器，(如果是对象，直接转为 JSON 数据)
/*@ResponseBody
@Controller*/
// @RestController == @Controller + @ResponseBody
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello() {
        return "Hello World quick!";
    }
}
