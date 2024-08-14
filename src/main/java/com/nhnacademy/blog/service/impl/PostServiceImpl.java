package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.Post;
import com.nhnacademy.blog.exception.PostNotFoundException;
import com.nhnacademy.blog.repository.PostRepository;
import com.nhnacademy.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        List<Post> postList = postRepository.findAll();
        if (postList.isEmpty()) {
            log.error("Class: PostServiceImpl method: getPosts returned null");
            throw new PostNotFoundException();
        }
        return postList;
    }

    @Override
    public Post getPost(Long id) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            log.error("Class: PostServiceImpl method: getPost returned null");
            throw new PostNotFoundException();
        }
        return post;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findPostByTitle(String title) {
        Post post = postRepository.findByTitle(title);
        if (post == null) {
            log.error("Class: PostServiceImpl method: findPostByTitle returned null");
            throw new PostNotFoundException();
        }
        return post;
    }

    @Override
    public void deletePostByPostKey(Long postKey) {
        postRepository.deleteById(postKey);
        log.info("deleted post by postKey: {}", postKey);
    }

    @Override
    public Post updatePostByPostTitleAndUserEmail(String title, String userEmail, Post post) {
        Post updatePost = postRepository.updatePostByTitleAndUserEmail(title, userEmail, post);
        if (updatePost == null) {
            log.error("Class: PostServiceImpl method: updatePostByPostTitleAndUserEmail returned null");
            throw new PostNotFoundException();
        }
        return updatePost;
    }
}
