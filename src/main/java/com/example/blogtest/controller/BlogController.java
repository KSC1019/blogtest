package com.example.blogtest.controller;

import com.example.blogtest.domain.Article;
import com.example.blogtest.dto.ArticleRequest;
import com.example.blogtest.dto.ArticleResponse;
import com.example.blogtest.dto.UpdateArticle;
import com.example.blogtest.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController		// HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // HTTP요청이 'POST /api/articles' 경로일 때 해당 메소드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody ArticleRequest request) { // RequestBody로 요청 본문 값 매핑
        Article article = blogService.save(request);
        ArticleResponse savedResponse = article.toResponse();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedResponse);
    }

    @RequestMapping(value = "/api/articles",method = RequestMethod.GET)
    // = @GetMapping
    public ResponseEntity<List<ArticleResponse>> showArticle(){
        List<Article> articleList = blogService.findAll();
        List<ArticleResponse> responseList = articleList.stream()
                .map(ArticleResponse::new).toList();

        return ResponseEntity.ok(responseList);
    }
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> showOne(@PathVariable Long id){
        Article one = blogService.findById(id);
        return ResponseEntity.ok(one.toResponse());
    }
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteOneArticle(@PathVariable Long id){
        blogService.deleteByid(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticle request) {
        Article updatedArticle = blogService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updatedArticle);
    }
}