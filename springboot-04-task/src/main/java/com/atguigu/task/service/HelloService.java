package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wangsen
 * @createtime 2018-11-08 15:26
 */
@Service
public class HelloService {

    @Async
    public void sayHello() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("事务处理成功....");

    }

}
