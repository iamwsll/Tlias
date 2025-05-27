package cn.iamwsll.mapper;

import cn.iamwsll.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/*
 * 员工Mapper接口
 * 处理员工数据库
 */
@Mapper
public interface EmpMapper {

    //原始方式分页
//    /*
//     * 总记录数
//     * @return 总记录数
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//
//    /*
//     * 分页查询员工
//     * 根据最后修改时间倒序排序
//     */
//    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start,Integer pageSize);


    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
}
