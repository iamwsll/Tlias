package cn.iamwsll.service.impl;

import cn.iamwsll.mapper.EmpMapper;
import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.PageResult;
import cn.iamwsll.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper; // 假设有一个EmpMapper用于数据库操作

//      原始分页查询方法
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count(); // 获取总记录数
//        List<Emp> rows = empMapper.list((page - 1) * pageSize, pageSize); // 分页查询员工数据
//      return new PageResult<Emp>(total, rows); // 创建分页结果对象
//    }
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize); // 使用PageHelper进行分页
        List<Emp> empList = empMapper.list(name,gender,begin,end);// 调用Mapper方法查询所有员工数据
        Page<Emp> p = (Page<Emp>) empList; // 将查询结果转换为Page对象 Page这个类是ArrayList的子类
        return new PageResult<>(p.getTotal(), p.getResult()); // 返回分页结果
    }
}
