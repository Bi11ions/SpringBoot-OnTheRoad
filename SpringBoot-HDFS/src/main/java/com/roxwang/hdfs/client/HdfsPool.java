package com.roxwang.hdfs.client;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class HdfsPool extends GenericObjectPool<Hdfs> {
    public HdfsPool(PooledObjectFactory<Hdfs> factory) {
        super(factory);
    }

    public HdfsPool(PooledObjectFactory<Hdfs> factory, GenericObjectPoolConfig<Hdfs> config) {
        super(factory, config);
    }

    public HdfsPool(PooledObjectFactory<Hdfs> factory, GenericObjectPoolConfig<Hdfs> config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
