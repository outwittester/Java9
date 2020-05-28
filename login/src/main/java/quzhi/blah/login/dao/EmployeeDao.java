package quzhi.blah.login.dao;

import quzhi.blah.login.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeDao {
    List getAll();
    Employee getOneEmployeeFromDatabase(Integer id);
    void insertEmployee(int no, String bday, String fname, String lname, String gender, String hday);
}
