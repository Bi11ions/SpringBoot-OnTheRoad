package com.atguigu.amqp;

import com.atguigu.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        // 创建exchange
//        Exchange exchange = new DirectExchange("amqpadmin.exchange");
//        amqpAdmin.declareExchange(exchange);
        // 创建队列
//        Queue queue = new Queue("amqpadmin.queue", true);
//        amqpAdmin.declareQueue(queue);

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                                            Binding.DestinationType.QUEUE,
                                        "amqpadmin.exchange",
                                        "amqp.haha", null));

        System.out.println("创建完成！");
    }

    /**
     * 1. 单播： 点对点
     */
    @Test
    public void contextLoads() {
        // 可以定制消息体和消息头
        //String msg = "This is SpringBoot's msg"
        //rabbitTemplate.send(exchange, routeKey, message);

        // object 默认作为消息体，只需要传入要发送的对象，自动序列化发送给 RabbitMQ
        //rabbitTemplate.convertAndSend(exchange, routeKey, object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        // 对象被默认序列化后发送，使用的是 jdk 的序列化方式， 可以自定义 MessageConverter 指定使用 JSON 序列化的方式
        rabbitTemplate.convertAndSend("exchange-direct", "roxwang.news", new Book("西游记", "吴承恩"));
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("roxwang.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsgByFanout() {
        Book book = new Book("三国演义", "罗贯中");
        rabbitTemplate.convertAndSend("exchange-fanout", "", book);
    }

}
