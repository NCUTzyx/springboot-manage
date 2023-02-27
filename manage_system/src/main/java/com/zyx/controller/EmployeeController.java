package com.zyx.controller;

import com.zyx.mapper.DepartmentMapper;
import com.zyx.mapper.EmployeeMapper;
import com.zyx.pojo.Department;
import com.zyx.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * 员工管理
 */

@Controller
public class EmployeeController {

    @Resource
    EmployeeMapper employeeMapper;

    @Resource
    DepartmentMapper departmentMapper;

    //用户列表页面 ==
    @RequestMapping("/user/emp")
    public String list(Model model){

        List<Employee> employees = this.employeeMapper.selectList(null);
        System.out.println(employees);
        model.addAttribute("emp",employees);
        return "/emp/list";
    }
    //添加页面 ==
    @RequestMapping(value = "/user/toAdd",method = RequestMethod.GET)
    public String toAddPage(Model model){

        //查出部门信息
        List<Department> departments = departmentMapper.selectList(null);
        System.out.println(departments);
        for (Department department : departments) {
            System.out.println(department.getDepartmentname());
        }

        model.addAttribute("departments",departments);
        return "/emp/add";
    }

    //添加操作 ==
    @PostMapping(value = "/user/toAdd")
    public String addEmp(Employee emp){

        //添加员工
        System.out.println("添加员工");
        System.out.println(emp);
        int insert = employeeMapper.insert(emp);
        System.out.println(insert >0 ? "插入成功":"插入失败");
        return "redirect:/user/emp";
    }
    //修改页面
    @RequestMapping(value = "/user/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id")Integer id ,Model model){

        //查出员工信息
        Employee employee = this.employeeMapper.selectById(id);
        model.addAttribute("emp",employee);
        //查出部门信息
        List<Department> departments = departmentMapper.selectList(null);
        System.out.println("部门信息为"+departments);
        model.addAttribute("departments",departments);

        return "/emp/update";
    }
    //修改操作
    @PostMapping(value = "/user/toUpdate")
    public String updateEmp(Employee emp){
        //修改员工
        System.out.println("修改员工");
        int update = employeeMapper.updateById(emp);
        System.out.println(update >0 ? "修改成功":"修改失败");
        return "redirect:/user/emp";
    }

    //删除操作 ==
    @GetMapping(value = "/user/toDelete/{id}")
    public String DeleteEmp(@PathVariable("id")int id){
        //删除员工
        employeeMapper.deleteById(id);
        return "redirect:/user/emp";
    }


}
