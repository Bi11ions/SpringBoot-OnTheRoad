package com.atguigu.roxwangspringbootstarter;

/**
 * @author wangsen
 * @createtime 2018-10-31 22:52
 */

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "roxwang.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
