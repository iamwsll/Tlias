package cn.iamwsll.service.impl;

import cn.iamwsll.mapper.EmpExprMapper;
import cn.iamwsll.mapper.EmpMapper;
import cn.iamwsll.pojo.*;
import cn.iamwsll.service.EmpLogService;
import cn.iamwsll.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogServiceImpl empLogService;

    //      原始分页查询方法
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count(); // 获取总记录数
//        List<Emp> rows = empMapper.list((page - 1) * pageSize, pageSize); // 分页查询员工数据
//      return new PageResult<Emp>(total, rows); // 创建分页结果对象
//    }
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize()); // 使用PageHelper进行分页
        List<Emp> empList = empMapper.list(empQueryParam);// 调用Mapper方法查询所有员工数据
        Page<Emp> p = (Page<Emp>) empList; // 将查询结果转换为Page对象 Page这个类是ArrayList的子类
        return new PageResult<>(p.getTotal(), p.getResult()); // 返回分页结果
    }

    @Transactional
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp); // 调用Mapper方法插入员工数据

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                // 补全员工表达式的基础属性
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList); // 批量插入员工表达式数据
            }
        } finally {
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工" + emp);
            empLogService.insertLog(empLog); // 向数据库记录新增员工日志
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        //批量删除员工的基本信息
        empMapper.deleteByIds(ids);
        //批量删除员工的工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id); // 根据ID查询员工信息
    }


}
