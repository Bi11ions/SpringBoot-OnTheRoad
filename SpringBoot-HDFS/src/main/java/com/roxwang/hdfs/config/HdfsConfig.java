package com.roxwang.hdfs.config;

import com.roxwang.hdfs.client.HdfsClient;
import com.roxwang.hdfs.client.HdfsFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HdfsConfig {
    @Value("${hadoop.hdfs.ip}")
    private String hdfsServerIp;

    @Value("${hadoop.hdfs.port}")
    private String hdfsServerPort;

    @Value("${hadoop.hdfs.userName}")
    private String userName;

    @Value("${hadoop.hdfs.pool.maxTotal}")
    private int maxTotal;

    @Value("${hadoop.hdfs.pool.maxIdle}")
    private int maxIdle;

    @Value("${hadoop.hdfs.pool.minIdle}")
    private int minIdle;

    @Value("${hadoop.hdfs.pool.maxWaitMillis}")
    private int maxWaitMillis;

    @Value("${hadoop.hdfs.pool.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${hadoop.hdfs.pool.minEvictableIdleTimeMillis:60000}")
    private long minEvictableIdleTimeMillis;

    @Value("${hadoop.hdfs.pool.timeBetweenEvictionRunsMillis:30000}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${hadoop.hdfs.pool.numTestsPerEvictionRun:-1}")
    private int numTestsPerEvictionRun;

    @Bean(initMethod = "init", destroyMethod = "stop")
    public HdfsClient HdfsClient() {
        return new HdfsClient();
    }

    /**
     * TestWhileConfig - 在空闲时检查有效性, 默认false
     * MinEvictableIdleTimeMillis - 逐出连接的最小空闲时间
     * TimeBetweenEvictionRunsMillis - 逐出扫描的时间间隔(毫秒) 如果为负数则不运行逐出线程，默认-1
     * NumTestsPerEvictionRun - 每次逐出检查时 逐出的最大数目
     */
    @Bean
    public HdfsPoolConfig HdfsPoolConfig() {
        HdfsPoolConfig hdfsPoolConfig = new HdfsPoolConfig();
        hdfsPoolConfig.setTestWhileIdle(testWhileIdle);
        hdfsPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        hdfsPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        hdfsPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        hdfsPoolConfig.setMaxTotal(maxTotal);
        hdfsPoolConfig.setMaxIdle(maxIdle);
        hdfsPoolConfig.setMinIdle(minIdle);
        hdfsPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return hdfsPoolConfig;
    }

    @Bean
    public HdfsFactory HdfsFactory() {
        return new HdfsFactory("hdfs://" + hdfsServerIp + ":" + hdfsServerPort, userName);
    }
}
