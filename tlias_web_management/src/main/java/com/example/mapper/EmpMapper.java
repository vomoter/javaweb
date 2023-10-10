package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    /*
     * 查询全部员工
     * @return
     */
    /*@Select("select * from emp limit #{start},#{end}")
    List<Emp> list(Integer start,Integer end);

    //统计员工总人数
    @Select("select count(*) from emp ")
    Long count();*/

    //使用pageHelper来实现分页查询
    /**
     * 员工信息查询
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //批量删除员工
    public void deleteByID(List<Integer> integerList);


    //根据ID查询员工
    @Select("select * from emp where id = #{id}")
    Emp select(Integer id);

    //新增员工
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    //修改员工
    void update(Emp emp);

    //员工登录
    @Select("select * from emp where username =#{username} and password = #{password}")
    Emp login(Emp emp);
}
