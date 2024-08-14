package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.BCategory;

import java.util.List;

public interface BCategoryService {
    List<BCategory> getAllCategories();

    BCategory getCategoryById(Long BCategoryId);

    BCategory createCategory(BCategory category);

    BCategory updateCategoryById(Long BCategoryId,BCategory category);

    void deleteCategory(Long BCategoryId);
}
