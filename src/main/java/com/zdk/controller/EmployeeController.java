package com.zdk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zdk.bean.Employee;
import com.zdk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 功能描述:
 * Created by zhaodengke on 2018/10/26.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getEmployee")
    public void getEmployee(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        // 引入pageHepler分页插件，在查询前调用 传入页面以及每页大小
        PageHelper.startPage(pageNum, 5);
        // startPage后面紧跟这的这个查询就是分页查询
        List<Employee> employeeList = this.employeeService.getEmployee();
        // 使用pageInfo包装查询之后的结果 连续显示的页数5
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeList, 5);
        model.addAttribute("pageInfo", pageInfo);
    }

    @ResponseBody
    @RequestMapping("/getEmployeeByPage")
    public PageInfo<Employee> getEmployee(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        // 引入pageHepler分页插件，在查询前调用 传入页面以及每页大小
        PageHelper.startPage(pageNum, 1);
        // startPage后面紧跟这的这个查询就是分页查询
        List<Employee> employeeList = this.employeeService.getEmployee();
        // 使用pageInfo包装查询之后的结果 连续显示的页数5
        return new PageInfo<Employee>(employeeList, 5);
    }
}
