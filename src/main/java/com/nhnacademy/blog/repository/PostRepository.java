package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    Post updatePostByTitleAndUserEmail(String title, String userEmail, Post post);
}
