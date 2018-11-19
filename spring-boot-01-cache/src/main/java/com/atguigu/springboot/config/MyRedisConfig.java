package com.atguigu.springboot.config;

import com.atguigu.springboot.bean.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangsen
 * @createtime 2018-11-05 15:48
 */
@Configuration
public class MyRedisConfig{

//    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> jsonSer = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(jsonSer);
        return template;
    }


    /**
     * 2.x 与 1.x 配置 CacheManager 的方式不同
     * @param factory
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        // 1. 初始化一个 RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        // 2. 设置其他的序列化方式 - 使用自定义的 FASTJSON 的序列化方式
//        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
//        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer);
//         RedisCacheConfiguration defaultConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);

        // 使用自带的 JSON 方式，这里使用 GenericJackson2JsonRedisSerializer 而不是 Jackson2JsonRedisSerializer
        RedisCacheConfiguration defaultConfiguration = RedisCacheConfiguration.defaultCacheConfig().
                                                    serializeValuesWith(RedisSerializationContext
                                                                        .SerializationPair
                                                                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));

        // 设置过期时间
        defaultConfiguration.entryTtl(Duration.ofSeconds(100));


        // 3. 新建 RedisCacheManager
        // 方式1：
//        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultConfiguration);
        // 方式2
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("my-cache");
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        // 这里设置的 key 值是存在的缓存空间，不同的缓存空间可以使用不同的配置
        configMap.put("emp", defaultConfiguration);
        // 设置 CacheNames
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                .initialCacheNames(cacheNames) // 可以在这声明缓存空间，并且初始化缓存空间必须在初始化配置之前执行。
                .withInitialCacheConfigurations(configMap)
                .build();

        // 设置 FastJSON 的白名单
//        ParserConfig.getGlobalInstance().addAccept("com.atguigu.springboot.bean.");


        return cacheManager;
    }

    /**
     * 设置 @Cacheable 的默认序列化方式
     * @return
     */
//    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer));

        return configuration;
    }

    /**
     * 自定义 template 的序列化方式
     * @param redisConnectionFactory
     * @return
     */
//    @Bean(name = "redisTemplate")
    @SuppressWarnings("unchecked")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


}
