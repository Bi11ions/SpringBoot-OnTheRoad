package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * SpringBoot 默认支持两种技术来和 ES 交互
 *  1. Jest (默认不生效)
 *      需要导入 jest 的工具包 (io.searchbox.client.JestClient)
 *  2. SpringData ElasticSearch [SpringData 引入的 ES 版本可能不合适]
 *      1) Client 节点信息 clusterNodes; clusterNames
 *      2) ElasticsearchTemplate 操作 ES
 *      3) 编写 ElasticsearchRepository 的子接口来操作 ES
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.atguigu.elastic.repository")
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }
}
