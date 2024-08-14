package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getBlogs();

    Blog getBlogByKey(long blogKey);

    Blog createBlog(Blog blog);

    Blog updateBlogByKey(Long blogKey, Blog blog);

    void deleteBlog(Long blogKey);
}
