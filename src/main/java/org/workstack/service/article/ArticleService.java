package org.workstack.service.article;

import org.workstack.model.Article;

import java.util.List;

public interface ArticleService {

    Article save(Article article);

    List<Article> findAll();
}
