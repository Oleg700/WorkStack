package org.workstack.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workstack.model.Article;
import org.workstack.model.Comment;
import org.workstack.repository.ArticleRepository;
import org.workstack.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment, long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        //comment.setArticle
        return commentRepository.save(comment);
    }
}
