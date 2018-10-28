package com.zdk.service.impl;

import com.zdk.bean.Employee;
import com.zdk.dao.EmployeeMapper;
import com.zdk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:
 * Created by zhaodengke on 2018/10/26.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmployee() {
        return this.employeeMapper.selectWithDept();
    }
}
