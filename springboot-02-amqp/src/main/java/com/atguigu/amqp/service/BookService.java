package com.atguigu.amqp.service;

import com.atguigu.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wangsen
 * @createtime 2018-11-06 16:14
 */
@Service
public class BookService {

    @RabbitListener(queues = "roxwang")
    public void receive(Book book) {
        System.out.println(book);
    }

    @RabbitListener(queues = "roxwang.news")
    public void getMessage(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
