package cn.iamwsll.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    * 分页结果类
    * 用于封装分页查询的结果
    * 类的成员需要与接口文档保持一致.因为类对象会被转换为JSON格式发给前端
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
