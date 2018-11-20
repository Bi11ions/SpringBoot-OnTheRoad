package com.atguigu.springboot;

import com.atguigu.springboot.utils.FastDFSClient;
import com.github.tobato.fastdfs.domain.StorePath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04WebRestfulcrudApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFastDFS() {
        StorePath storePath = FastDFSClient.uploadFile(new File("C:/Users/abb/Desktop/goods001.jpg"));
        System.out.println(storePath.getPath());
        System.out.println(storePath.getFullPath());
        FastDFSClient.getResAccessUrl(storePath.getFullPath());
    }
}
