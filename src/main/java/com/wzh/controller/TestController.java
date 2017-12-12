package com.wzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/")
    public String index(Map<String,Object> map){
     //   ModelAndView modelAndView=new ModelAndView("/index");
       // modelAndView.addObject("message","WORLDINMINE");
        map.put("message","World In Mine");
        return "index";

    }

    /**
     * 捕获类内所有的异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ModelAndView exceptionHandelByThymeleaf(Exception ex,HttpServletRequest req){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("error");
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        return mav;
    }
}
