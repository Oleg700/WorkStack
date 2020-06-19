package org.workstack.service.comment;

import org.workstack.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment save(Comment comment, long articleId, String username);
}
