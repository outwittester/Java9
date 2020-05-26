package com.example.demoadmin.controller;

import com.example.demoadmin.model.Employee;
import com.example.demoadmin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class CrudController {

    @Autowired
    private EmployeeService employeeService;

    // login page -> input data -> data submitted to index page and show the page
    @GetMapping("index")
    public String index(@ModelAttribute() Employee employee, Model model) {
        List employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        System.out.println(employee);
        return "index";
    }


    // 增
    @GetMapping("add")
    public String addPage(Model model) {
        return "add";
    }

    @PostMapping("add")
    public String addImpl(HttpServletRequest httpServletRequest, Model model) {
        String emp_no_input = httpServletRequest.getParameter("emp_no");
        String first_name_input = httpServletRequest.getParameter("first_name");
        String last_name_input = httpServletRequest.getParameter("last_name");
        String gender_input = httpServletRequest.getParameter("gender");
        Employee employee = employeeService.addOneEmployee(Integer.parseInt(emp_no_input),
                first_name_input, last_name_input, gender_input);
        System.out.println("add " + employee);
        return "redirect:/admin/index";
    }


    // 删
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id) {
        Integer emp_no = id;
        employeeService.deleteOneEmployee(emp_no);
        return "redirect:/admin/index";
    }


    // 改
    // url:{id}/update 都会展现出 update.html 这个 view
    // 在 get 的时候，取得当前这个 employeeObj 这个对象，
    // 然后通过 model.addAttribute 方法，把这个 object 赋给 view 中名为 employee 的 object
    // 这样就可以在下一步 form 提交的时候，调用 Post 方法的时候通过 httpServletRequest.getParameter 取得 emp_no
    @GetMapping("{id}/update")
    public String updatePage(Model model, @PathVariable Integer id) {
        Integer emp_no = id;
        Employee employeeObj = employeeService.getOneEmployee(emp_no);
        model.addAttribute("employee", employeeObj);
        return "update";
    }

    // update.html 这个 view 中利用 HttpServletRequest 拿到数据，调用 service 层的方法，submit 之后 redirect回/admin/index
    @PostMapping("update")
    public String updateImpl(HttpServletRequest httpServletRequest) {
        Integer emp_no = Integer.parseInt(httpServletRequest.getParameter("id"));
        System.out.println(emp_no);
        String first_name = httpServletRequest.getParameter("first_name");
        Employee employee = employeeService.updateFirstName(emp_no, first_name);
        System.out.println("update " + employee);
        return "redirect:/admin/index";
    }


    //查
    @GetMapping("search")
    public String search(HttpServletRequest httpServletRequest, Model model) {
        String emp_no_str = httpServletRequest.getParameter("emp_no");
        Integer emp_no = Integer.parseInt(emp_no_str);
        Employee employee = employeeService.getOneEmployee(emp_no);
        model.addAttribute("employee", employee);
        return "search";
    }
}
