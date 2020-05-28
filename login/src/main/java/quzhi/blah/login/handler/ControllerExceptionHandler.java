package quzhi.blah.login.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice //AOP
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) {
        //        at console level
        //AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        System.out.println("coming here");
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e.getMessage());
        mv.setViewName("error/error");
        return mv;
    }
}
