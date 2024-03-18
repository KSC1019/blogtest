package com.example.blogtest.dto;

public class UpdateArticle {
    private String title;
    private String content;

    public UpdateArticle(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
