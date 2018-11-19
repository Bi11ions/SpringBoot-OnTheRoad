package com.atguigu.springboot.controller;

import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @createtime 2018-10-30 15:20
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

}
