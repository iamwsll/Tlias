package cn.iamwsll.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;//数据库中字段叫create_time(为了符合规范,数据库字段都是下划线命名)
    private LocalDateTime updateTime;//数据库中字段叫update_time(为了符合规范,数据库字段都是下划线命名)
}
