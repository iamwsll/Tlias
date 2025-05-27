package cn.iamwsll.service.impl;

import cn.iamwsll.mapper.EmpMapper;
import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.PageResult;
import cn.iamwsll.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper; // 假设有一个EmpMapper用于数据库操作

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Long total = empMapper.count(); // 获取总记录数
        List<Emp> rows = empMapper.list((page - 1) * pageSize, pageSize); // 分页查询员工数据
      return new PageResult<Emp>(total, rows); // 创建分页结果对象
    }
}
