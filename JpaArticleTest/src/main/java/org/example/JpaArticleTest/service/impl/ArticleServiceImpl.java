package org.example.text_test.service.impl;

import org.example.text_test.entity.Article;
import org.example.text_test.repository.ArticleRepository;
import org.example.text_test.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(long id) {
        return null;
    }

    @Override
    public Article findArticleById(long id){
        return articleRepository.findById(id);
    }
}
