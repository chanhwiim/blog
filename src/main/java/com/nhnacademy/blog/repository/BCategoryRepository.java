package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.BCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BCategoryRepository extends JpaRepository<BCategory, Long> {

    BCategory updateBCategoryByBCategoryId(Long bCategoryId, BCategory bCategory);
}
