package com.atguigu.importannotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 *
 * @author wangsen@qgutech.com
 * @since 2018/12/18 16:50
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * AnnotationMetadata : 当前 @Import 注解的类的所有注解信息
     * @return 返回值就是导入到容器中的组件的全类名
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.atguigu.bean.Green", "com.atguigu.bean.Red"};
    }
}
