package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.Blog;
import com.nhnacademy.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/blogs")
    public String getBlogs(Model model) {
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @GetMapping("/{blogKey}")
    public String getBlogByKey(Model model,@PathVariable long blogKey){
        Blog blog = blogService.getBlogByKey(blogKey);
        model.addAttribute("blog", blog);
        return "blog";
    }

    @PostMapping("/blogs")
    public String createBlog(Model model, Blog blog){
        Blog newBlog = blogService.createBlog(blog);
        model.addAttribute("blog", newBlog);
        return "redirect:/blog";
    }

    @PostMapping("/update/{blogKey}")
    public String updateBlogByKey(Model model ,@PathVariable Long blogKey, Blog blog){
        blogService.updateBlogByKey(blogKey, blog);
        return "redirect:/blog";
    }

    @DeleteMapping
    public String deleteBlog(Model model, Long blogKey){
        blogService.deleteBlog(blogKey);
        return "redirect:/blogs";
    }
}
