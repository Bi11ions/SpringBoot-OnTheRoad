package com.atguigu.roxwangspringbootstarter;

/**
 * @author wangsen
 * @createtime 2018-10-31 22:51
 */
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return helloProperties.getPrefix()+"-"+name+"-"+helloProperties.getSuffix();
    }

}
