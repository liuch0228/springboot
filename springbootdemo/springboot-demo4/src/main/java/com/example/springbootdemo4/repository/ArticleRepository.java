package com.example.springbootdemo4.repository;

import com.example.springbootdemo4.domain.Article;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Document(indexName = "blog", type = "article", shards = 1, replicas = 0)
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {


}
