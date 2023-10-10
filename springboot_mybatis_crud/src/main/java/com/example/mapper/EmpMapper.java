package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //根据ID删除数据
    @Delete("delete from emp where id =#{id}")
    public int delete(Integer id);

    //添加Emp
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //修改员工信息
    /*  数据封装：
    *   实体类属性名和数据库查询返回的字段名一致，mybatis会指定封装
    *   如果实体类属性名和数据库表查询返回的字段名不一致，自动封装
    * */
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}," +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    //根据ID查询
    @Select("select *from  emp where id = #{id}")

    //方案一：给字段起别名，让别名与实体类属性一致
    // @Select("select id, username, password, name, gender, image, job, entrydate, dept_id," +
    //        "create_time createTime, update_time updateTime from emp where id = #{id}")

    //方案二:开启mybatis的驼峰命名自动映射开关 ---a cloumn-- --> aColumn

    public Emp getID(Integer id);

    //条件查询员工
    /*@Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
            "entrydate between #{begin} and #{end} order by update_time desc ")*/
    public List<Emp> list(String name, Short gender, LocalDate begin , LocalDate end);

    //动态更新员工信息
    public void update2(Emp emp);

    //批量删除员工
    public void deleteByID(List<Integer> integerList);

    //查询所有员工信息
    @Select("select * from emp")
    public List<Emp> AllSelect();
}
