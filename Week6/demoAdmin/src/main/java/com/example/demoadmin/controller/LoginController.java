package com.example.demoadmin.controller;

import com.example.demoadmin.model.Employee;
import com.example.demoadmin.model.User;
import com.example.demoadmin.service.EmployeeService;
import com.example.demoadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String login(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) {
        String user_id = httpServletRequest.getParameter("user_id");
        String password = httpServletRequest.getParameter("password");
        User user = userService.checkUser(user_id, password);
        if (user != null) {
            httpSession.setAttribute("user", user);
            return "redirect:/admin/index";
        }

        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "login";
    }

}
