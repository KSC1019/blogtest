package com.example.blogtest.dto;

import com.example.blogtest.domain.Article;
import lombok.*;
import org.springframework.web.ErrorResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ArticleResponse {
    private Long id;
    private String title;
    private String content;

    public ArticleResponse(Article article){
        title = article.getTitle();
        content = article.getContent();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
