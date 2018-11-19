package com.atguigu.springboot.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

/**
 * @author wangsen
 * @createtime 2018-11-01 9:42
 */
//@Configuration
public class MyBatisConfig {
//    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
