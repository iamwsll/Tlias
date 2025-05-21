package cn.iamwsll.controller;

import cn.iamwsll.pojo.Dept;
import cn.iamwsll.pojo.Result;
import cn.iamwsll.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    /**
     * 查询所有部门
     */
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList =  deptService.findAll();
        return Result.success(deptList);
    }
    /**
     * 删除某个id的部门
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println("删除部门数据,id+"+id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 添加部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        System.out.println("添加部门数据,id+"+dept);
        deptService.add(dept);
        return Result.success();
    }

}
