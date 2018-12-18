package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 17:29
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个对象，并将对象加入到容器中
     */
    public Color getObject() throws Exception {
        System.out.println("get Color Object");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 设置是否为单例模式
     */
    public boolean isSingleton() {
        return false;
    }
}
