package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void Delete() {
      int result=empMapper.delete(18);
      System.out.println(result);
      System.out.println("OK");
    }

   //新增员工
    @Test
    public void testInsert() {
        //构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行新增员工信息操作
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    //修改员工信息
    @Test
    public  void testUpdate(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(21);
        emp.setUsername("Tim");
        emp.setName("题目");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行更新员工操作
        empMapper.update(emp);
    }

    @Test
    public void testSelect(){
       Emp emp=empMapper.getID(20);
       System.out.println(emp);
    }

    @Test
    public void testList(){
       // List<Emp> empList=empMapper.list("张",(short)1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
        List<Emp> empList=empMapper.list(null,(short)1,null,null);
        System.out.println(empList);
    }

    //动态跟新员工信息
    //更新ID为21的员工 username=Taylor, name=泰勒, gender=2
    @Test
    public void testUpdate2(){

        Emp  emp=new Emp();
        emp.setId(21);
        emp.setUsername("Taylor");
        emp.setName("泰勒");
        emp.setGender((short)2);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update2(emp);
    }

    //批量删除员工 id为(14,15,16)
    @Test
    public void deleteByID(){
        List<Integer> integerList= Arrays.asList(14,15,16);
        empMapper.deleteByID(integerList);
    }

    //查询所有员工信息
    @Test
    public void AllSelect(){
        List<Emp> empList = empMapper.AllSelect();
        System.out.println(empList);
    }
}
