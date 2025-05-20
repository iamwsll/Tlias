package cn.iamwsll.service;

import cn.iamwsll.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     */
    List<Dept> findAll();
}
