package com.example.demoadmin.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        System.out.println("arrived exception handler");
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", httpServletRequest.getRequestURL());
        mv.addObject("exception", e.getMessage());
        mv.setViewName("error/error");
        return mv;
    }
}
