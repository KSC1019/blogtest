package com.example.blogtest.repository;

import com.example.blogtest.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
    List<Article> findBytitle(String title);

    void deleteByid(Long id);

}