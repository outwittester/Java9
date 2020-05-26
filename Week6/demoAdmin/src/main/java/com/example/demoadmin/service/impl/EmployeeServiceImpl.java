package com.example.demoadmin.service.impl;

import com.example.demoadmin.dao.EmployeeDao;
import com.example.demoadmin.model.Employee;
import com.example.demoadmin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getOneEmployee(Integer emp_no) {
        return employeeDao.getOneEmployeeDao(emp_no);
    }

    @Override
    @Transactional
    public List getEmployeeList() {
        return employeeDao.getEmployeeListDao();
    }

    @Override
    @Transactional
    public Employee addOneEmployee(Integer emp_no, String first_name, String last_name, String gender) {
        return employeeDao.addOneEmployeeDao(emp_no, first_name, last_name, gender);
    }

    @Override
    public void deleteOneEmployee(Integer emp_no) {
        employeeDao.deleteOneEmployeeDao(emp_no);
    }

    @Override
    public Employee updateFirstName(Integer emp_no, String first_name) {
        return employeeDao.updateFirstNameDao(emp_no, first_name);
    }
}
