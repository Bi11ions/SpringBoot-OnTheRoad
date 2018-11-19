package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wangsen
 * @createtime 2018-11-05 17:43
 */
@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Cacheable(value={"dept"})
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

}
