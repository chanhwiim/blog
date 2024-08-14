package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.Post;
import com.nhnacademy.blog.repository.PostRepository;
import com.nhnacademy.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public void deletePostByPostKey(Long postKey) {
        postRepository.deleteById(postKey);
    }

    @Override
    public Post updatePostByPostTitleAndUserEmail(String title, String userEmail, Post post) {
        return postRepository.updatePostByTitleAndUserEmail(title, userEmail, post);
    }
}
