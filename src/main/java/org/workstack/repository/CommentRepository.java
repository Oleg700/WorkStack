package org.workstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.workstack.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
