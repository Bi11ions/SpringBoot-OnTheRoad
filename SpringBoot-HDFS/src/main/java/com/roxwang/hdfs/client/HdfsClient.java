package com.roxwang.hdfs.client;

import com.roxwang.hdfs.config.HdfsPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HdfsClient {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private HdfsPool hdfsPool;

    @Autowired
    private HdfsPoolConfig hdfsPoolConfig;

    @Autowired
    private HdfsFactory hdfsFactory;

    public void init() {
        hdfsPool = new HdfsPool(hdfsFactory, hdfsPoolConfig);
    }

    public void stop() {
        hdfsPool.close();
    }

    public long getPathSize(String path) throws Exception {
        Hdfs hdfs = null;
        try {
            hdfs = hdfsPool.borrowObject();
            return hdfs.getContentSummary(path).getLength();
        } catch (Exception e) {
            logger.error("[HDFS]获取路径大小失败", e);
            throw e;
        } finally {
            if (null != hdfs) {
                hdfsPool.returnObject(hdfs);
            }
        }
    }

    public List<String> listByPath(String path) {
        Hdfs hdfs = null;
        try {
            hdfs = hdfsPool.borrowObject();
            return hdfs.listFileName(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != hdfs) {
                hdfsPool.returnObject(hdfs);
            }
        }
    }

    public List<String> getBasePath() {
        Hdfs hdfs = null;
        try {
            hdfs = hdfsPool.borrowObject();
            return hdfs.listFileName("/");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != hdfs) {
                hdfsPool.returnObject(hdfs);
            }
        }
    }
}
