package com.atguigu.springboot.exception;

/**
 * @author wangsen
 * @createtime 2018-10-26 14:31
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在!");
    }
}
