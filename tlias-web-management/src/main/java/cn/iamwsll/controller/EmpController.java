package cn.iamwsll.controller;

import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.PageResult;
import cn.iamwsll.pojo.Result;
import cn.iamwsll.service.EmpService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询员工数据,page:{},pageSize:{}", page, pageSize);
        PageResult<Emp> pageResult =  empService.page(page, pageSize);
        return Result.success(pageResult);
    }

}
