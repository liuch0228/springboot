package com.example.springbootdemo4.controller;

import com.example.springbootdemo4.domain.Article;
import com.example.springbootdemo4.repository.ArticleRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/v1/article")
public class ElasticTestController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 启动本机ES,postman请求 http://localhost:8080/api/v1/article/save
     * localhost:9200/blog/article/3 查看当前插入的内容
     * @return
     */
    @GetMapping("/save")
    @ResponseBody
    public Object save(){
        Article article = new Article();
        article.setContent("this is content");
        article.setId(3L);
        article.setPv(888);
        article.setTitle("this is title");
        articleRepository.save(article);
        return "success";
    }
    /** localhost:9200/blog/article/3 返回数据：
     * {
     *     "_index": "blog",
     *     "_type": "article",
     *     "_id": "3",
     *     "_version": 1,
     *     "found": true,
     *     "_source": {
     *         "id": 3,
     *         "title": "this is title",
     *         "summary": null,
     *         "content": "this is content",
     *         "pv": 888
     *     }
     * }
     */

    /**
     * http://localhost:8080/api/v1/article/search?title=springboot
     * 响应：{"content":[{"id":1,"title":"这个是小D课堂推出springboot全套系列课","summary":"搜索框架整合","content":"springboot整合elasticsearch，这个是新版本 2018年录制","pv":123}],"pageable":{"sort":{"sorted":false,"unsorted":true,"empty":true},"offset":0,"pageNumber":0,"pageSize":1,"paged":true,"unpaged":false},"facets":[],"aggregations":null,"scrollId":null,"maxScore":0.67893237,"totalElements":1,"totalPages":1,"number":0,"size":1,"sort":{"sorted":false,"unsorted":true,"empty":true},"numberOfElements":1,"first":true,"last":true,"empty":false}
     *  https://www.elastic.co/guide/en/elasticsearch/reference/5.6/query-dsl-multi-match-query.html
     *
     * @param title
     * @return
     */
    @GetMapping("/search")
    @ResponseBody
    public Object search(String title){
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
        Iterable<Article> list = articleRepository.search(queryBuilder);
        return list;
    }

    /**
     * http://localhost:8080/api/v1/article/multiMatchQuery?keywords=springboot
     * 多字段匹配查询：https://www.elastic.co/guide/en/elasticsearch/reference/5.6/query-dsl-multi-match-query.html
     * 本例在title，summary字段上面查找请求的关键字,如果title字段上面查不到，就去summary字段上面查
     * @param keywords 要查找的关键字
     * @return
     */
    @GetMapping("/multiMatchQuery")
    @ResponseBody
    public Object multiMatchQuery(String keywords){
        MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keywords, "title", "summary");
        Iterable<Article> list = articleRepository.search(queryBuilder);
        return list;
    }

}
