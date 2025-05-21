package cn.iamwsll.controller;

import cn.iamwsll.pojo.Dept;
import cn.iamwsll.pojo.Result;
import cn.iamwsll.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
    /**
     * 查询所有部门
     */
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList =  deptService.findAll();
        return Result.success(deptList);
    }
    /**
     * 删除某个id的部门
     */
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除部门数据,id:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 添加部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门数据,dept:{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据id查询部门
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询部门数据,id:{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 根据id更新部门(其实是更新部门名称)
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门数据,dept:{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
