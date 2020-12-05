package com.roxwang.hdfs;

import com.roxwang.hdfs.client.HdfsClient;
import com.roxwang.hdfs.client.HdfsPool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HdfsApplication.class)
public class HdfsTest {
    @Autowired
    private HdfsClient hdfsClient;

    private Logger log = LoggerFactory.getLogger(HdfsPool.class);

    @Test
    public void testConnect() throws Exception {
        // 设置 Hadoop_Home， windows 调试过程中也可以将其设置在环境变量中
        System.setProperty("hadoop.home.dir", "D:\\Java Program\\hadoop-2.7.2");
        List<String> basePath = hdfsClient.listByPath("/user/root/input");
        for (String path : basePath) {
            log.info("path:{}", path);
        }
    }
}
