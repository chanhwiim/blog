package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentService{

    List<Comment> findAll();

    Comment findCommentByKey(long commentKey);

    Comment save(Comment comment);

    Comment updateCommentByCommentKey(Long commentKey,Comment comment);

    void deleteByKey(long commentKey);
}
