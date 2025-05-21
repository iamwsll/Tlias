package cn.iamwsll.mapper;

import cn.iamwsll.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     */
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();

    /**
     * 删除某个id的部门
     * 我们忽略了返回值.
     */
    @Select("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     */
    @Select("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门
     */
    @Select("select id,name,create_time,update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门
     */
    @Select("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
