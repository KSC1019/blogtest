package com.example.blogtest.dto;

import com.example.blogtest.domain.Article;

import java.time.LocalDateTime;

public class ArticleVResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    public ArticleVResponse(){

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public ArticleVResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }

}
