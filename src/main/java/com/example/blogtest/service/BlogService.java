package com.example.blogtest.service;

import com.example.blogtest.domain.Article;
import com.example.blogtest.dto.ArticleRequest;
import com.example.blogtest.dto.UpdateArticle;
import com.example.blogtest.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Article save(ArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    public Article findById(Long id) {
        blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found id" + id));
        return blogRepository.findById(id).orElse(new Article());
    }

    public void deleteByid(Long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticle request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }

}