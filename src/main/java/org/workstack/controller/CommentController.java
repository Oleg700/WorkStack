package org.workstack.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.Comment;
import org.workstack.model.dto.CommentDto;
import org.workstack.service.comment.CommentService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/articles/{id}/comments")
    public Comment save(@PathVariable("id") final long articleId,
                        @Valid @RequestBody CommentDto commentDto, Principal principal) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        String currentUsername = principal.getName();
        return commentService.save(comment, articleId, currentUsername);
    }
}
