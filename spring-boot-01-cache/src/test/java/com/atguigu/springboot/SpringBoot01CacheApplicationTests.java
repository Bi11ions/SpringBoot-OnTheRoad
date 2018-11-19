package com.atguigu.springboot;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.apache.catalina.webresources.EmptyResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;// 操作 k-v 都是对象的

    // 自定义 template
    @Autowired
    RedisTemplate empRedisTemplate;// 操作 k-v 都是对象的

    @Autowired
    StringRedisTemplate stringRedisTemplate; // 操作 k-v 都是字符串的

    @Test
    public void testRedis02() {
        Employee emp = employeeMapper.getEmpById(1);
        /**
         * 默认如果存储对象，使用的是 JDK 的序列化规则，序列化后保存到 redis 中
         *
         * 如果想将数据保存为 json 数据存入 redis 中
         *  1. 可以使先将对象转为 JSON 字符串，再保存到Redis中
         *  2. 自定义 Redis 配置类，修改默认的序列化规则
         */
        empRedisTemplate.opsForValue().set("emp-01", emp);
    }

    /**
     * Redis 常见的五大类型
     *   String, List, Set, Hash, ZSet(有序集合)
     *   stringRedisTemplate.opsForValue()->[String]
     *   stringRedisTemplate.opsForList()->[List]
     *   stringRedisTemplate.opsForSet()->[Set]
     *   stringRedisTemplate.opsForHash()->[Hash]
     *   stringRedisTemplate.opsForZSet()->[ZSet]
     */
    @Test
    public void testRedis() {
//        stringRedisTemplate.opsForValue().append("msg", "helloworld");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }


    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
