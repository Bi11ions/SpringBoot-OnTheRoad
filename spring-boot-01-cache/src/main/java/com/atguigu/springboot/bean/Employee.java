package com.atguigu.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangsen
 * @createtime 2018-11-01 9:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
