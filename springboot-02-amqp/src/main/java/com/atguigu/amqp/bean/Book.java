package com.atguigu.amqp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangsen
 * @createtime 2018-11-06 16:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookName;
    private String author;
}
