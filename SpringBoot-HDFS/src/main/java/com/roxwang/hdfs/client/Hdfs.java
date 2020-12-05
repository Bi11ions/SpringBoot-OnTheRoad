package com.roxwang.hdfs.client;

import com.google.common.collect.Lists;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ContentSummary;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Hdfs {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private FileSystem fs;
    private String coreResource;
    private String hdfsResource;
    private final String url;
    private final String userName;
    private static final String NAME = "fs.hdfs.impl";

    public Hdfs(String url, String userName) {
        this.url = url;
        this.userName = userName;
    }

    public void open() {
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", url);
            logger.info("url is " + url);
            fs = FileSystem.get(new URI(url), conf, userName);
            logger.info("[Hadoop]创建实例成功");
        } catch (Exception e) {
            logger.error("[Hadoop]创建实例失败", e);
        }
    }

    public void close() {
        try {
            if (null != fs) {
                fs.close();
                logger.info("[Hadoop]关闭实例成功");
            }
        } catch (Exception e) {
            logger.error("[Hadoop]关闭实例失败", e);
        }
    }

    public boolean isConnected() throws IOException {
        return fs.exists(new Path("/"));
    }

    public boolean exists(String path) throws IOException {
        Path hdfsPath = new Path(path);
        return fs.exists(hdfsPath);
    }


    public FileStatus getFileStatus(String path) throws IOException {
        Path hdfsPath = new Path(path);
        return fs.getFileStatus(hdfsPath);
    }

    public ContentSummary getContentSummary(String path) throws IOException {
        ContentSummary contentSummary = null;
        Path hdfsPath = new Path(path);
        if (fs.exists(hdfsPath)) {
            contentSummary = fs.getContentSummary(hdfsPath);
        }
        return contentSummary;
    }


    public List<String> listFileName(String path) throws IOException {
        List<String> res = Lists.newArrayList();
        FileStatus[] fileStatuses = fs.listStatus(new Path(path));
        for (FileStatus fileStatus : fileStatuses) {
            res.add(fileStatus.getPath() + "：类型--" + (fileStatus.isDirectory() ? "文件夹" : "文件"));
        }
        return res;
    }

}
