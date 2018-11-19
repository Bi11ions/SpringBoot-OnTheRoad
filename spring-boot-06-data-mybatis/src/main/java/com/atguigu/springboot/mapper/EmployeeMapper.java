package com.atguigu.springboot.mapper;

import com.atguigu.springboot.Bean.Employee;

/**
 * @author wangsen
 * @createtime 2018-10-30 14:22
 */
// 使用配置文件的方式配置 Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee emp);
}
