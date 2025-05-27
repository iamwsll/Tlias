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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
     * @param page 页码
     * @param pageSize 每页显示的行数
     * @return 分页结果
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询员工数据,参数:{}", empQueryParam);
        PageResult<Emp> pageResult =  empService.page(empQueryParam);
        return Result.success(pageResult);
    }

}
