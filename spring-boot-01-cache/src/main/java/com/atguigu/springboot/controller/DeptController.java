package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-11-05 17:45
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return deptService.getDeptById(id);
    }

}
