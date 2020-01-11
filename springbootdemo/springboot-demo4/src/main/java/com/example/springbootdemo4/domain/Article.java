package com.example.springbootdemo4.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 文章对象
 * @Document注解表示每个Article对象就是一条es的记录，
 * 把该对象存放到blog库的article表中
 */
@Document(indexName = "blog", type = "article")
public class Article implements Serializable {

    private long id;
    private String title;
    private String summary;
    private String content;
    private int pv;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
