package org.workstack.service.comment;

import org.springframework.stereotype.Service;
import org.workstack.model.Article;
import org.workstack.model.Comment;
import org.workstack.model.User;
import org.workstack.repository.ArticleRepository;
import org.workstack.repository.CommentRepository;
import org.workstack.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    private ArticleRepository articleRepository;

    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, ArticleRepository articleRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment, long articleId, String username) {
        Optional<Article> article = articleRepository.findById(articleId);
        User user = userRepository.findByUsername(username);
        comment.setArticle(article.get());
        comment.setUser(user);
        return commentRepository.save(comment);
    }
}
