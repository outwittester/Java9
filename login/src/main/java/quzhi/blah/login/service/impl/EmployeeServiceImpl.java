package quzhi.blah.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quzhi.blah.login.dao.EmployeeDao;
import quzhi.blah.login.model.Employee;
import quzhi.blah.login.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List getAllFromDao() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getOneEmployeeFromDao(Integer id) {
        return employeeDao.getOneEmployeeFromDatabase(id);
    }

    @Override
    public void insertToDao(int no, String bday, String fname, String lname, String gender, String hday) {
        employeeDao.insertEmployee(no,bday,fname,lname,gender,hday);
    }

}
