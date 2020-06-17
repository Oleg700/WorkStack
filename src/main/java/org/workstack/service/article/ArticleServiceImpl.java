package org.workstack.service.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.workstack.model.Article;
import org.workstack.repository.ArticleRepository;

public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }
}
