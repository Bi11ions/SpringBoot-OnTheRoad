package com.atguigu.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangsen
 * @create 2018-08-29 20:35
 */

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties: 告诉 Spring Boot 将本类的所有属性和配置文件相关的配置进行绑定
 *      prefix = "person" 配置文件中那个节点下的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能使用容器提供的 @ConfigurationProperties 功能
 *
 * @PropertySource(value={""}) 可以导入指定位置的配置文件
 *
 */
@PropertySource(value={"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    /**
     * 相当于
     * <bean class="Person">
     *     <property name="lastName" value="字面量/${key} 从环境变量、配置文件中获取值/#{SqEL}"></property>
     * </bean>
     */
//    @Value("${person.last-name}")
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;


    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
