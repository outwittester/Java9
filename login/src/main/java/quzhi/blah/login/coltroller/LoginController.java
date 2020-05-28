package quzhi.blah.login.coltroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import quzhi.blah.login.model.Employee;
import quzhi.blah.login.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public String loginPage()
    {
        return ("login");
    }
    @GetMapping("signup")
    public String signup()
    {
        return "signup";
    }
    @GetMapping("singupsubmit")
    public String signupAction(HttpServletRequest request){
        String no = request.getParameter("no");
        String bday = request.getParameter("bday");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gen = request.getParameter("gender");
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String today = DateFor.format(Calendar.getInstance().getTime());
        System.out.println(today);

        System.out.println(no+" "+bday+" "+fname+" "+lname+" "+gen);
        try {
            employeeService.insertToDao(Integer.parseInt(no), bday, fname, lname, gen, today);
            return "success";
        }catch(Exception e)
        {
            e.printStackTrace();
            return "fail";
        }


    }

    @GetMapping("submit")
    public String loginPageAction(@ModelAttribute Employee employee, HttpServletRequest request, Model model) {
        String num = request.getParameter("no");
        String bd = request.getParameter("bday");

        Employee oneEmployeeFromDao = employeeService.getOneEmployeeFromDao(Integer.parseInt(num));
//        model.addAttribute("employees", oneEmployeeFromDao);
        Date birth_date = oneEmployeeFromDao.getBirth_date();
        String b = birth_date.toString();
        String bday = b.replace("-", "");
        //bday = bday.replace("/", "");
        System.out.println(bday);
        System.out.println(num);
        System.out.println(bd);
        System.out.println("current employee is ");
        System.out.println(oneEmployeeFromDao);
        if(bd.equals(bday))
            return "success";
        else
            return "fail";
    }

}
