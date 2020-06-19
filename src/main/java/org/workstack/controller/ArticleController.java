package org.workstack.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.Article;
import org.workstack.model.dto.ArticleDto;
import org.workstack.service.article.ArticleService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/articles")
    public List<Article> getAll() {
        return articleService.findAll();
    }

    @PostMapping(value = "/articles")
    public Article save(@Valid @RequestBody ArticleDto articleDto, Principal principal) {
        Article article = modelMapper.map(articleDto, Article.class);
        String currentUsername = principal.getName();
        return articleService.save(article, currentUsername);
    }
}
