package com.atguigu.elastic.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author wangsen
 * @createtime 2018-11-07 17:56
 */
@Document(indexName = "atguigu", type = "book")
@Data
public class Book {
    private Integer id;
    private String bookName;
    private String author;
}
