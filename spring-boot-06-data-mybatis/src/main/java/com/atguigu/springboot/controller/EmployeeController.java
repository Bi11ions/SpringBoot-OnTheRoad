package com.atguigu.springboot.controller;

import com.atguigu.springboot.Bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-10-30 14:33
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return employeeMapper.getEmpById(id);
    }

}
