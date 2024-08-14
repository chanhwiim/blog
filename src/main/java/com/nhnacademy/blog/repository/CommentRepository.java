package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment updateCommentByCommentKey(Long commentKey, Comment comment);
}
