package cn.iamwsll.mapper;

import cn.iamwsll.pojo.Emp;
import cn.iamwsll.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

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


    public List<Emp> list(EmpQueryParam empQueryParam); // 分页查询员工数据，使用EmpQueryParam作为查询参数对象


    /**
     * 插入员工数据
     * @param emp 员工对象
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") // 主键返回:mybatis提供的,会把插入到数据库后的主键重新赋值给emp
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values(#{username},#{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID批量删除员工
     * @param ids 员工ID列表
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工信息
     * @param id 员工ID
     * @return 员工对象
     */
    Emp getById(Integer id);
}
