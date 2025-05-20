package cn.iamwsll.service.impl;

import cn.iamwsll.mapper.DeptMapper;
import cn.iamwsll.pojo.Dept;
import cn.iamwsll.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
