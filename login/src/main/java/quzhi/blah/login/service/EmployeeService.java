package quzhi.blah.login.service;

import quzhi.blah.login.model.Employee;

import java.util.List;

public interface EmployeeService {
    List getAllFromDao();
    Employee getOneEmployeeFromDao(Integer id);
    void insertToDao(int no, String bday, String fname, String lname, String gender, String hday);
}
