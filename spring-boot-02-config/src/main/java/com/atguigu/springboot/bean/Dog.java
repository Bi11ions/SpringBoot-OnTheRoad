package com.atguigu.springboot.bean;

import java.util.Date;

/**
 * @author wangsen
 * @create 2018-08-29 20:37
 */
public class Dog {

    private String name;
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
