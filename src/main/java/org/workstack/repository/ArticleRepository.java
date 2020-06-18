package org.workstack.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workstack.model.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @EntityGraph(value = "article-graph", type = EntityGraph.EntityGraphType.LOAD)
    List<Article> findAll();
}
