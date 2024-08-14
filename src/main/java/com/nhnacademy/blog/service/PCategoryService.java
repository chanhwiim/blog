package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.PCategory;

import java.util.List;

public interface PCategoryService {
    List<PCategory> findAll();

    PCategory findById(Long id);

    PCategory findByName(String name);

    PCategory save(PCategory category);

    PCategory saveLowLevel(PCategory category, String parentId);

    PCategory updatePCategoryFromIdAndName(Long id, String name, PCategory category);

    void delete(PCategory category);
}
