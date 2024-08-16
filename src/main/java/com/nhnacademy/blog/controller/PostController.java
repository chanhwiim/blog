package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.Post;
import com.nhnacademy.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> postList = postService.getPosts();
        log.info("Post List count is: {}", postList.size());
        model.addAttribute("postList", postList);
        return "posts";
    }

    @GetMapping("/{postKey}")
    public String getPost(Model model, @PathVariable Long postKey) {
        Post post = postService.getPost(postKey);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/create")
    public Post createPost(Post post) {
        Post createdPost = postService.createPost(post);
        log.info("Created post: {}", createdPost);
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
        Post updatePost = postService.updatePostByPostTitleAndUserEmail(title, userEmail, post);
        log.info("Update post title is: {}", updatePost.getTitle());
        return updatePost;
    }
}
