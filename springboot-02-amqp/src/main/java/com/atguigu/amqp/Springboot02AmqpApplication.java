package com.atguigu.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *  1. RabbitAutoConfiguration
 *  2. 有自动配置了连接工厂：ConnectionFactory
 *  3. RabbitProperties 封装了 RabbitMQ 的配置
 *  4.  RabbitTemplate: 给 RabbitMQ 发送和接受消息
 *  5.  AmqpAdmin: RabbitMQ 系统管理功能组件
 *        amqpAdmin: 创建和删除 Queue，Exchange，Binding
 *  6. @EnableRabbit + @RabbitListener 设置监听消息队列的内容
 */

@EnableRabbit
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }
}
