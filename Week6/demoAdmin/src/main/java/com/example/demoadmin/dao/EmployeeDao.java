package com.example.demoadmin.dao;

import com.example.demoadmin.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee getOneEmployeeDao(Integer emp_no);
    public List getEmployeeListDao();
    public Employee addOneEmployeeDao(Integer emp_no, String first_name, String last_name, String gender);
    public void deleteOneEmployeeDao(Integer emp_no);
    public Employee updateFirstNameDao(Integer emp_no, String first_name);
}
