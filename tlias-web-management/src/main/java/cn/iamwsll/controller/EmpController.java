package cn.iamwsll.controller;

import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.EmpQueryParam;
import cn.iamwsll.pojo.PageResult;
import cn.iamwsll.pojo.Result;
import cn.iamwsll.service.EmpService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

/*
    * 员工管理 控制器
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工数据
     * @param empQueryParam 分页查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询员工数据,参数:{}", empQueryParam);
        PageResult<Emp> pageResult =  empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工:{}", emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工数据,ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询员工信息,id:{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
}
