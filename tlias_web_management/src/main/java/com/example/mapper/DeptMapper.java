package com.example.mapper;

import com.example.pojo.Dept;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /*
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    //根据ID删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //新增部门
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    //根据ID查询部门
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);

    @Update("update dept set update_time = #{updateTime},name =#{name} where id =#{id}")
    void update(Dept dept);
}