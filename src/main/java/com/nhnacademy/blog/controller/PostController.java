package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.Post;
import com.nhnacademy.blog.exception.CreatePostFailedException;
import com.nhnacademy.blog.exception.UpdateIsFailedException;
import com.nhnacademy.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postKey}")
    public Post getPost(@PathVariable Long postKey) {
        return postService.getPost(postKey);
    }

    @PostMapping("/create")
    public Post createPost(Post post) {
        Post createdPost = postService.createPost(post);

        if (createdPost == null) {
            throw new CreatePostFailedException();
        }

        return createdPost;
    }

    @GetMapping("/{title}")
    public Post findPostByTitle(@PathVariable String title) {
        return postService.findPostByTitle(title);
    }

    @DeleteMapping("/delete/{postKey}")
    public void deletePostByPostKey(@PathVariable Long postKey) {
        postService.deletePostByPostKey(postKey);
    }

    @PostMapping("/update")
    public Post updatePostByPostTitleAndUserEmail(String title, String userEmail, Post post) {
        Post before = postService.findPostByTitle(title);
        Post updatePost = postService.updatePostByPostTitleAndUserEmail(title, userEmail, post);

        if (before.equals(updatePost)) {
            throw new UpdateIsFailedException();
        }

        return updatePost;
    }
}
