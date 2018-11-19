package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author wangsen
 * @createtime 2018-11-01 9:46
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee getEmpById(Integer id);

    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);

    @Insert("insert into employee(lastName, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{did})")
    int addEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    int delEmpById(Integer id);

    @Update("update employee set lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} where id=#{id}")
    int updateEmp(Employee employee);
}

