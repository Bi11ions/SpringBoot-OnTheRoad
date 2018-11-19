package com.atguigu.springboot.controller;

import com.atguigu.springboot.Bean.Department;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-10-30 13:30
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department dept){
        departmentMapper.insertDept(dept);
        return dept;
    }
}
