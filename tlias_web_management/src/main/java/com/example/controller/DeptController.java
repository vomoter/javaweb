package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    /**
     * 部门管理Controller
     */

        @Autowired
        private DeptService deptService;

        /**
         * 查询部门数据
         * @return
         */

        @GetMapping
        public Result list() {
            log.info("查询全部部门数据");
            //调用service查询部门数据
            List<Dept> deptList = deptService.list();
            return Result.success(deptList);
        }

    //删除部门
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:id={}", id);
        //调用service的删除方法
        deptService.delete(id);
        return Result.success();
    }

    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {

        log.info("薪增部门:{}", dept);
        //调用service的新增方法
        deptService.add(dept);
        return Result.success();
    }

    //根据ID查询部门
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("/根据ID查询部门,id:{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改的部门为:{}", dept);
        //调用service的修改方法
        deptService.update(dept);
        return Result.success();
    }

    }
