package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.Comment;
import com.nhnacademy.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments")
    public String findAll(Model model) {
        List<Comment> comments = commentService.findAll();
        log.info("Found {} comments", comments.size());
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping("/{commentKey}")
    public String findCommentByKey(Model model,@PathVariable long commentKey) {
        Comment comment = commentService.findCommentByKey(commentKey);
        log.info("Found comment {}", comment);
        model.addAttribute("comment", comment);
        return comment.getCommentKey().toString();
    }

    @PostMapping("/save")
    public String save(Model model, Comment comment) {
        Comment savedComment = commentService.save(comment);
        log.info("Saved comment {}", savedComment);
        model.addAttribute("comment", savedComment);
        return "redirect:/post/" + savedComment.getPost();
    }

    @PostMapping
    public String updateCommentByCommentKey(Model model, Long commentKey, Comment comment) {
        Comment updatedComment = commentService.updateCommentByCommentKey(commentKey, comment);
        log.info("Updated comment {}", updatedComment);
        model.addAttribute("comment", updatedComment);
        return "redirect:/post/" + updatedComment.getPost();
    }

    @DeleteMapping
    public String deleteByKey(long commentKey) {
        commentService.deleteByKey(commentKey);
        return "redirect:/comments";
    }
}
