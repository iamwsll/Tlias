package cn.iamwsll.mapper;

import cn.iamwsll.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
    * 员工工作经历Mapper接口
    * 处理员工工作经历数据库
 */
@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工ID查询工作经历
     * @param empIds 员工ID
     */
    void deleteByEmpIds(List<Integer> empIds);
}
