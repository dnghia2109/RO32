package com.example.demojparelationship.repository.ManyToMany;

import com.example.demojparelationship.entity.ManyToMany.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
}
