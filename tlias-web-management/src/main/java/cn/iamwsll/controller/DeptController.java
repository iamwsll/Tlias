package cn.iamwsll.controller;

import cn.iamwsll.pojo.Dept;
import cn.iamwsll.pojo.Result;
import cn.iamwsll.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    /**
     * 查询所有部门
     */
    @GetMapping("/depts")  //等同于上面
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList =  deptService.findAll();
        return Result.success(deptList);
    }

}
