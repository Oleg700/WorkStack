package org.workstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.Article;
import org.workstack.service.article.ArticleService;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/articles")
    public List<Article> getAll() {
        return articleService.findAll();
    }

    @PostMapping(value = "/articles")
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }

}
