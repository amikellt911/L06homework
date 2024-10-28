package org.example.text_test.repository;

import org.example.JpaArticleTest.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {
    Article findById(long id);

    void deleteById(long id);
}
