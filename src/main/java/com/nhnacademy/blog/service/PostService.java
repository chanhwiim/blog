package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

    Post getPost(Long postKey);

    Post createPost(Post post);

    Post findPostByTitle(String title);

    void deletePostByPostKey(Long postKey);

    Post updatePostByPostTitleAndUserEmail(String title, String userEmail, Post post);
}
