package com.example.demoadmin.service;

import com.example.demoadmin.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getOneEmployee(Integer emp_no);
    public List getEmployeeList();
    public Employee addOneEmployee(Integer emp_no, String first_name, String last_name, String gender);
    public void deleteOneEmployee(Integer emp_no);
    public Employee updateFirstName(Integer emp_no, String first_name);
}
