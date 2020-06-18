package org.workstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.Comment;
import org.workstack.service.comment.CommentService;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/articles/{id}/comments")
    public Comment save(@PathVariable("id") final long articleId, @RequestBody Comment comment){
        return commentService.save(comment, articleId);
    }
}
