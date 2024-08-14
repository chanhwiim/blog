package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.PCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCategoryRepository extends JpaRepository<PCategory, Long> {
    PCategory findByName(String name);

    PCategory savePCategoryByParentId(PCategory pCategory, String parentId);

    PCategory updatePCategoryByCategoryIdAAndCategoryName(Long id, String categoryName, PCategory parentCategory);
}
