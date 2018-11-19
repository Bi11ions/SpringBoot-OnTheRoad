package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangsen
 * @create 2018-08-30 19:23
 */
@Controller
public class PageController {

    @RequestMapping({"/", "/index.html"})
    public String index() {
        return "index";
    }


    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        // 默认去 classpath: /templates/success.html
        map.put("hello", "你好");
        List<String> users = new ArrayList<>();
        users.add("AAA");
        users.add("BBB");
        users.add("CCC");
        users.add("DDD");
        map.put("users", users);

        return "success";
    }

}
