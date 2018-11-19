package com.atguigu.springboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wangsen
 * @createtime 2018-10-30 17:20
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner ... run ..." + Arrays.asList(args));
    }
}
