package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {
}
