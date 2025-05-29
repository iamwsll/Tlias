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
}
