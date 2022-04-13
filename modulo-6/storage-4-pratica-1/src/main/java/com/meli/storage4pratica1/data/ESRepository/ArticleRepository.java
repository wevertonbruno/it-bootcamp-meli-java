package com.meli.storage4pratica1.data.ESRepository;

import com.meli.storage4pratica1.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
}
