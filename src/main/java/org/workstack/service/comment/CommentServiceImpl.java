package org.workstack.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.workstack.model.Comment;
import org.workstack.repository.CommentRepository;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
