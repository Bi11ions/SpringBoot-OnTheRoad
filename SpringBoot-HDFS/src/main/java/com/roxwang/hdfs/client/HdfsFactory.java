package com.roxwang.hdfs.client;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.io.IOException;

public class HdfsFactory implements PooledObjectFactory<Hdfs> {
    private String url;
    private String userName;

    public HdfsFactory() {
    }

    public HdfsFactory(String url, String userName) {
        this.url = url;
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PooledObject<Hdfs> makeObject() throws Exception {
        Hdfs hdfs = new Hdfs(url, userName);
        hdfs.open();
        return new DefaultPooledObject<Hdfs>(hdfs);
    }

    public void destroyObject(PooledObject<Hdfs> pooledObject) throws Exception {
        Hdfs hdfs = pooledObject.getObject();
        hdfs.close();
    }

    public boolean validateObject(PooledObject<Hdfs> pooledObject) {
        Hdfs hdfs = pooledObject.getObject();
        try {
            return hdfs.isConnected();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void activateObject(PooledObject<Hdfs> pooledObject) throws Exception {

    }

    public void passivateObject(PooledObject<Hdfs> pooledObject) throws Exception {

    }
}
