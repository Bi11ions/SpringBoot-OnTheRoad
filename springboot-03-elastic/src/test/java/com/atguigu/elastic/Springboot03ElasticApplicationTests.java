package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import com.atguigu.elastic.bean.Book;
import com.atguigu.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void findBy() {
        List<Book> list = bookRepository.findByBookNameLike("游");
        for (Book book: list) {
            System.out.println(book);
        }
    }

    @Test
    public void test02() {
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.save(book);
    }

    @Test
    public void contextLoads() {
        // 1. 给 ES 中索引(保存)一个文档
        Article article = new Article();
        article.setId(1);
        article.setAuthor("张sir");
        article.setTitle("好消息");
        article.setContent("Hello world!");

        // 构建一个索引
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        // 执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
