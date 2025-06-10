package cn.iamwsll.controller;

import cn.iamwsll.pojo.JobOption;
import cn.iamwsll.pojo.Result;
import cn.iamwsll.service.EmpLogService;
import cn.iamwsll.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /*
        统计员工职位数量
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("查询员工职位数据");
        JobOption jobOption =  reportService.getEmpJobData();
        return Result.success(jobOption);
    }
}
