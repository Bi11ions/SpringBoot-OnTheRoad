package com.atguigu.elastic.repository;

import com.atguigu.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * @author wangsen
 * @createtime 2018-11-07 17:36
 */
public interface BookRepository extends ElasticsearchCrudRepository<Book, Integer> {

    List<Book> findByBookNameLike(String bookName);

}
