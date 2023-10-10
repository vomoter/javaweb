package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    //初始方式

  /*
  @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        //获取请求参数
        String name = request.getParameter("name");
        String ageString = request.getParameter("age");

        int age=Integer.parseInt(ageString);
        System.out.println(name+"="+age);
        return "OK";
    }*/

    //简单参数：与形参变量名相同，定义参数即可接收参数参数
    @RequestMapping("/simpleParam")
    public String simpleParam(String name,int age){
        System.out.println(name+"="+age);
        return "OK";
    }


}
