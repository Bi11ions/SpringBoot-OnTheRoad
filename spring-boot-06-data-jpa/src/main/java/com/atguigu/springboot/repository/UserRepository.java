package com.atguigu.springboot.repository;

import com.atguigu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangsen
 * @createtime 2018-10-30 15:13
 */
// 继承 JpaRepository
public interface UserRepository extends JpaRepository<User, Integer> {

}
