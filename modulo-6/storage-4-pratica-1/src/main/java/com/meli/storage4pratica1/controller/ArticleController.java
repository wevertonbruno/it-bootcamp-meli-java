package com.meli.storage4pratica1.controller;

import com.meli.storage4pratica1.domain.Article;
import com.meli.storage4pratica1.dto.CreateArticleDTO;
import com.meli.storage4pratica1.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> create(@RequestBody CreateArticleDTO createArticleDTO) {
        Article article = articleService.create(createArticleDTO);
        return ResponseEntity.ok(article);
    }
}
