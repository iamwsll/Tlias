package cn.iamwsll.service.impl;

import cn.iamwsll.mapper.EmpMapper;
import cn.iamwsll.pojo.JobOption;
import cn.iamwsll.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceimpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        // 调用Mapper方法获取员工职位数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //组装结果并且返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList,dataList);
    }
}
