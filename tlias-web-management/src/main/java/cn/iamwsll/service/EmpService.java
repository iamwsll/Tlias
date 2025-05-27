package cn.iamwsll.service;

import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    /**
     * 分页查询员工
     *
     * @param page     当前页码
     * @param pageSize 每页显示的记录数
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return 分页结果
     */
    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
