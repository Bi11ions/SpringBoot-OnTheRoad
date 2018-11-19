package com.atguigu.elastic.bean;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * @author wangsen
 * @createtime 2018-11-07 16:01
 */
@Data
public class Article {
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

}
