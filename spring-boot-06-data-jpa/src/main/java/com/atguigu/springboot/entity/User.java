package com.atguigu.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author wangsen
 * @createtime 2018-10-30 15:07
 */
// 使用 JPA 注解，配置映射关系

@Entity
@Table(name="tbl_user") // 指定关联数据表, 如果省略，默认表名为类名小写
@Setter
@Getter
public class User {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置自增
    private Integer id;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column
    private String email;
}
