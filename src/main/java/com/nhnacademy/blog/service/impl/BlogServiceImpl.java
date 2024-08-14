package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.Blog;
import com.nhnacademy.blog.repository.BlogRepository;
import com.nhnacademy.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogByKey(long blogKey) {
        return blogRepository.findById(blogKey).orElse(null);
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlogByKey(Long blogKey, Blog blog) {
        return blogRepository.updateBlogByBlogKey(blogKey, blog);
    }

    @Override
    public void deleteBlog(Long blogKey) {
        blogRepository.deleteById(blogKey);
    }
}
