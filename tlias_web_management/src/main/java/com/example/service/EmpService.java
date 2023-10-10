package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end);

    /* //查询员工总人数
    Long count();
*/
    //根据ID删除员工
    void delete(List<Integer> integerList);

    //根据ID查询员工
    Emp getById(Integer id);

    //新增员工
    void insert(Emp emp);

    //修改员工
    void update(Emp emp);

    //员工登录
    Emp login(Emp emp);
}
