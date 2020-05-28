package quzhi.blah.login.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import quzhi.blah.login.dao.EmployeeDao;
import quzhi.blah.login.mapper.EmployeeMapper;
import quzhi.blah.login.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeImpl implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List getAll() {
        String sql = String.format("SELECT * FROM employees limit 10");
        try{
            List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
            //System.out.println(maps);
            return maps;

        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public Employee getOneEmployeeFromDatabase(Integer id) {
        String sql = String.format("select * from employees where emp_no='%s'", id);
        System.out.println(sql);
        RowMapper mapper = new EmployeeMapper();
        try {
            Employee employee = (Employee) jdbcTemplate.queryForObject(sql, mapper);
            //System.out.println(employee);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return new Employee();
        }

    }

    @Override
    public void insertEmployee(int no, String bday, String fname, String lname, String gender, String hday) {

        String sql = String.format("insert into employees values (%d,'%s','%s','%s','%s','%s');", no, bday, fname, lname, gender, hday);
        //System.out.println(sql);
        jdbcTemplate.execute(sql);


    }
}
