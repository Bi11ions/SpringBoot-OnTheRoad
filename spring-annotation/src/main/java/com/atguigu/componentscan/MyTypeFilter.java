package com.atguigu.componentscan;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 15:13
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 读取到当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前扫描类的资源信息（路径...）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("-->" + className);
        if (className.contains("er")) {
            return true;
        }

        return false;
    }
}
