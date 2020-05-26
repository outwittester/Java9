package com.example.demoadmin.dao.impl;

import com.example.demoadmin.dao.EmployeeDao;
import com.example.demoadmin.mapper.EmployeeMapper;
import com.example.demoadmin.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmplolyeeDaoImpl implements EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Employee getOneEmployeeDao(Integer emp_no) {
        String emp_no_str = Integer.toString(emp_no);
        String sql = String.format("SELECT * FROM employees WHERE emp_no = '%s'", emp_no_str);
        RowMapper rowMapper = new EmployeeMapper();
        try {
            Employee employee = (Employee) jdbcTemplate.queryForObject(sql, rowMapper);
            System.out.println(employee);
            return employee;
        }
        catch(Exception e) {
            e.printStackTrace();
            return new Employee();
        }
    }

    @Override
    public List getEmployeeListDao() {
        String sql = String.format("SELECT * FROM employees LIMIT 20");
        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
            return result;
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public Employee addOneEmployeeDao(Integer emp_no, String first_name, String last_name, String gender) {
        String emp_no_str = Integer.toString(emp_no);
        String sql = String.format("INSERT INTO employees VALUES (%s, '2020-02-02', '%s', '%s', '%s', '2020-02-02')",
                emp_no_str, first_name, last_name, gender);
        String sqlAfterUpdate = String.format("SELECT * FROM employees WHERE emp_no = %s", emp_no_str);
        RowMapper rowMapper = new EmployeeMapper();
        try {
            jdbcTemplate.update(sql);
            Employee employee = (Employee) jdbcTemplate.queryForObject(sqlAfterUpdate, rowMapper);
            System.out.println("inserted:" + employee);
            return employee;
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("insert failed");
            return null;
        }
    }

    @Override
    public void deleteOneEmployeeDao(Integer emp_no) {
        String emp_no_str = Integer.toString(emp_no);
        String sql = String.format("DELETE FROM employees WHERE emp_no = %s", emp_no_str);
        try {
            jdbcTemplate.update(sql);
            System.out.println("deleted");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("delete failed");
        }
    }

    @Override
    public Employee updateFirstNameDao(Integer emp_no, String first_name) {
        String emp_no_str = Integer.toString(emp_no);
        String sql = String.format("UPDATE employees SET first_name = '%s' WHERE emp_no = %s", first_name, emp_no_str);
        String sqlAfterUpdate = String.format("SELECT * FROM employees WHERE emp_no = %s", emp_no_str);
        RowMapper rowMapper = new EmployeeMapper();
        try {
            jdbcTemplate.update(sql);
            Employee employee = (Employee) jdbcTemplate.queryForObject(sqlAfterUpdate, rowMapper);
            System.out.println("updated:" + employee);
            return employee;
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("update failed");
            return null;
        }
    }
}
