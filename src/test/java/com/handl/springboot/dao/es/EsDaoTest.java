package com.handl.springboot.dao.es;

import com.handl.springboot.SpringbootDemoApplicationTests;
import com.handl.springboot.pojo.es.Article;
import com.handl.springboot.pojo.es.Author;
import com.handl.springboot.pojo.es.Tutorial;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by handl on 2017/9/9.
 */
public class EsDaoTest extends SpringbootDemoApplicationTests {

    @Autowired
    private EsDao esDao;

    @Test
    public void ceratIndex(){
        Author author=new Author(1L,"handl","da niu");

        Tutorial tutorial=new Tutorial(1L,"elastic");

        Article article =new Article(1L,"springboot integreate elasticsearch",
                "springboot integreate elasticsearch is very easy",
                "elasticsearch based on lucene,spring-data-elastichsearch based on elaticsearch,this tutorial tell you how to integrete springboot with spring-data-elasticsearch",
                new Date(),1L,author,tutorial);

        //创建保存索引
        esDao.save(article);
    }

    @Test
    public void testSearch(){
        String queryString="springboot";//搜索关键字
        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = esDao.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}

