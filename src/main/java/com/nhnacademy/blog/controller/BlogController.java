package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.Blog;
import com.nhnacademy.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/blogs")
    private String getBlogs(Model model) {
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @GetMapping("/{blogKey}")
    private String getBlogByKey(Model model,@PathVariable long blogKey){
        Blog blog = blogService.getBlogByKey(blogKey);
        model.addAttribute("blog", blog);
        return "blog";
    }

    @PostMapping("/blogs")
    private String createBlog(Model model, Blog blog){
        Blog newBlog = blogService.createBlog(blog);
        model.addAttribute("blog", newBlog);
        return "redirect:/blog";
    }

    @PostMapping("/update/{blogKey}")
    private String updateBlogByKey(Model model ,@PathVariable Long blogKey, Blog blog){
        blogService.updateBlogByKey(blogKey, blog);
        return "redirect:/blog";
    }

    @DeleteMapping
    private String deleteBlog(Model model, Long blogKey){
        blogService.deleteBlog(blogKey);
        return "redirect:/blogs";
    }
}
