package com.example.controller;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    //员工登录
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录的用户信息：{}", emp);
        //调用service的登录方法
        Emp e = empService.login(emp);

        //登录成功，生成令牌，下发令牌
        if (e != null) {
            Map<String, Object> claim = new HashMap<>();
            claim.put("id", e.getId());
            claim.put("name", e.getName());
            claim.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claim);

            JwtUtils.generateJwt(claim);    //jwt包含了当前登录的员工信息
            return Result.success(jwt);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或者密码错误");
    }
}
