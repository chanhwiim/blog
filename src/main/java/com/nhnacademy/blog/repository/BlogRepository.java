package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    Blog updateBlogByBlogKey(Long blogKey, Blog blog);
}
