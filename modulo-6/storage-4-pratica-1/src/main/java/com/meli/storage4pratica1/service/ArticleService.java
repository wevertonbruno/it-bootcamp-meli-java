package com.meli.storage4pratica1.service;

import com.meli.storage4pratica1.data.ESRepository.ArticleRepository;
import com.meli.storage4pratica1.domain.Article;
import com.meli.storage4pratica1.dto.CreateArticleDTO;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article create(CreateArticleDTO articleDto) {
        Article article = new Article(null, articleDto.getTitle(), articleDto.getAuthors());
        return articleRepository.save(article);
    }
}
