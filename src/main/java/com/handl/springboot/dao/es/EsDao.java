package com.handl.springboot.dao.es;

import com.handl.springboot.pojo.es.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by handl on 2017/9/9.
 *
 * Elasticsearch的数据层，继承spring的ElasticsearchRepository
 * 类似于JPA的Repository
 *
 *
 * 在测试类中编写测试案例
 *
 *
 */
public interface EsDao extends ElasticsearchRepository<Article,Long> {
}
