package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.Comment;
import com.nhnacademy.blog.repository.CommentRepository;
import com.nhnacademy.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findCommentByKey(long commentKey) {
        return commentRepository.findById(commentKey).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateCommentByCommentKey(Long commentKey, Comment comment) {
        return commentRepository.updateCommentByCommentKey(commentKey, comment);
    }

    @Override
    public void deleteByKey(long commentKey) {
        commentRepository.deleteById(commentKey);
    }
}
