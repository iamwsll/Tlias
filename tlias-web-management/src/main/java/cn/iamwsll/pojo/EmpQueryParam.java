package cn.iamwsll.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page = 1; // 当前页码，默认为1
    private Integer pageSize = 10; // 每页显示的记录数，默认为10
    private String name; // 员工姓名
    private Integer gender; // 性别，1为男，2为女
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 开始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 结束日期
}
