package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.componentscan.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 13:50
 * <p>
 * "@Configuration" 标明这是一个配置类
 * "@ComponentScan":
 *      value:指定要扫描的包
 *      excludeFilters=Filter[]:指定过滤不扫描的类
 *      includeFilters=Filter[]:配置只包含那些类，需要禁用默认扫描规则
 *          type: FilterType.ANNOTATION:按照注解过滤
 *                FilterType.ASSIGNABLE_TYPE:按照给定类型
 *                FilterType.ASPECTJ:按照 ASPECTJ 表达式
 *                FilterType.REGEX: 使用正则指定
 *                FilterType.CUSTOM: 自定义规则
 * "@ComponentScans"=@Configuration[]:指定多种扫描规则，在 jdl1.8 中@ComponentScan 被标注了@Repeatable(ComponentScans.class)，
 *                                      可以直接写多个@ComponentScan。
 */
@Configuration
@ComponentScan(value = "com.atguigu", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
}, useDefaultFilters = false)
public class MainConfig {

    @Bean(value = "person")
    public Person person() {
        return new Person("李四", 20);
    }
}