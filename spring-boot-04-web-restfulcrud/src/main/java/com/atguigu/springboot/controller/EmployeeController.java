package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author wangsen
 * @createtime 2018-10-25 16:44
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * url : /emps
     * method : get
     * 查询所有员工信息，返回列表页面
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);
        // thymeleaf 会自动拼串
        // classpath:/templates/xxx.html
        return "emp/list";
    }

    /**
     * 员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 返回添加页面之前，查询所有部门信息，并加入页面中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 来到添加页面
        return "emp/add";
    }

    /**
     * url : /emp
     * method : post
     * 添加员工
     * SpringMvc 自动将请求参数和入参对象进行一一绑定:请求参数的名字和 JavaBean 入参的
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面

        //保存员工
        employeeDao.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * url:/emp/{id}
     * method: get
     * 修改员工信息，在页面回显员工信息
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 返回添加页面之前，查询所有部门信息，并加入页面中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 回到修改页面(回到修改添加页面)
        return "emp/add";
    }

    /**
     * url : /emp
     * method : put
     * 员工修改,需要提交员工id
     */
    @PutMapping("/emp")
    public String udpateEmp(Employee employee) {

        employeeDao.save(employee);

        return "redirect:/emps";
    }

    /**
     * url:/emp
     * method: delete
     * 删除员工
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        return "redirect:/emps";
    }

}
