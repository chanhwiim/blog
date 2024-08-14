package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}
