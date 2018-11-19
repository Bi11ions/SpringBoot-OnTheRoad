package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangsen
 * @createtime 2018-10-26 14:47
 */
@ControllerAdvice
public class MyExceptionHandler {
//
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user not exist");
//        map.put("message", e.getMessage());
//        return map;
//    }
//

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        /**
         * 设置自定义状态码
         */
        request.setAttribute("javax.servlet.error.status_code", 500);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "user not exist");
        map.put("message", "用户出错啦");

        request.setAttribute("ext", map);
        return "forward:/error";
    }

}
