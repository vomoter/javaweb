package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    //根据ID批量删除员工信息
    @Override
    public void delete(List<Integer> integerList) {
        empMapper.deleteByID(integerList);
    }

    //根据ID查询员工信息
    @Override
    public Emp getById(Integer id) {
        return empMapper.select(id);
    }

    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    //员工登录
    @Override
    public Emp login(Emp emp) {
       return empMapper.login(emp);
    }


}
