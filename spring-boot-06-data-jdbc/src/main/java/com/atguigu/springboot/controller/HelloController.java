package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author wangsen
 * @createtime 2018-10-29 17:15
 */
@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    @ResponseBody
    public Map<String, Object> map() {
        List<Map<String, Object>> results = jdbcTemplate.queryForList("select * from department");

        return results.get(0);
    }

}
