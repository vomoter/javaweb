package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//在运行时，会自动生成该接口的实现类对象（代理对象），并且将该对象交给IOC容器
@Mapper
public interface UserMapper {

    //查询全部用户信息
    @Select("select * from uni_student")
    public List<User> list();
}

