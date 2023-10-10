package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    /**
     * 员工管理Controller
     */
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    //根据ID批量删除员工信息
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除操作, ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    //根据ID查询员工信息
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id) {
        log.info("查询员工, id:{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    //新增员工
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("新增的员工为：{}",emp);
        empService.insert(emp);
        return Result.success();
    }

    //修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改的员工为：{}",emp);
        empService.update(emp);
        return Result.success(emp);
    }



}
