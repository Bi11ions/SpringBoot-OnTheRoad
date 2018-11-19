package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-11-01 10:06
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp(id);
        return employee;
    }


    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }


    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
