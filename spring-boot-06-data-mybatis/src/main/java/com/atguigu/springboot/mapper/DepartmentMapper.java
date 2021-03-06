package com.atguigu.springboot.mapper;

import com.atguigu.springboot.Bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author wangsen
 * @createtime 2018-10-30 13:24
 */
//@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDepetById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("Insert into department(department_name) values(#{departmentName})")
    int insertDept(Department dept);

    @Update("Update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department dept);
}
