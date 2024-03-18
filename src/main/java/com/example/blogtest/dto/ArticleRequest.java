package com.example.blogtest.dto;

import com.example.blogtest.domain.Article;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {	// 생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }


}