package quzhi.blah.login.mapper;

import org.springframework.jdbc.core.RowMapper;
import quzhi.blah.login.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmp_no(resultSet.getInt("emp_no"));
        employee.setBirth_date(resultSet.getDate("birth_date"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setHire_date(resultSet.getDate("hire_date"));
        return employee;
    }
}