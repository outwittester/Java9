package com.example.demoadmin.interceptor;

import com.example.demoadmin.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    //防止用户跳过 login 页面直接去到 index 页面，所以添加拦截器，必须取得 user object 才能跳转
    //如果不加拦截器 admin/index 就可以跳过 login 进入页面
    //这里 preHandle 的做法是，如果拿不到 user 这个 object，那么就 redirect 到 /admin/login
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object Handler) throws Exception {
        System.out.println("arrived interceptor");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            httpServletResponse.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
