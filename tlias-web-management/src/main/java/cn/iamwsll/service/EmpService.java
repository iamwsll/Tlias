package cn.iamwsll.service;

import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.EmpQueryParam;
import cn.iamwsll.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询员工
     * @param empQueryParam 分页查询参数
     * @return 分页结果
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
        * 保存员工信息
     */
    void save(Emp emp);

    void delete(List<Integer> ids);
}
