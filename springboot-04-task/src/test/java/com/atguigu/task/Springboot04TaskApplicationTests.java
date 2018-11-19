package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("通知：今晚不加班");
        message.setText("今晚 6:00 下班");
        message.setTo("roxwang@aliyun.com");
        message.setFrom("roxwang@foxmail.com");

        javaMailSender.send(message);

    }

    @Test
    public void testMessage() throws MessagingException {
        // 1. 创建一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知：今晚不加班");
        helper.setText("<b style='color:red'>今晚 6:00 下班</b>", true);
        helper.setTo("roxwang@aliyun.com");
        helper.setFrom("roxwang@foxmail.com");

        helper.addAttachment("1.jpg", new File("G:\\我的图片\\IMG_0464.JPG"));

        javaMailSender.send(mimeMessage);
    }


}
