package org.example.text_test.service;

import org.example.text_test.entity.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticleList();
    public Article getArticleById(long id);

    Article findArticleById(long id);
}
