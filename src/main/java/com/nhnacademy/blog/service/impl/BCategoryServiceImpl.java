package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.BCategory;
import com.nhnacademy.blog.repository.BCategoryRepository;
import com.nhnacademy.blog.service.BCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BCategoryServiceImpl implements BCategoryService {

    private final BCategoryRepository bCategoryRepository;

    @Override
    public List<BCategory> getAllCategories() {
        return bCategoryRepository.findAll();
    }

    @Override
    public BCategory getCategoryById(Long BCategoryId) {
        return bCategoryRepository.findById(BCategoryId).orElse(null);
    }

    @Override
    public BCategory createCategory(BCategory category) {
        return bCategoryRepository.save(category);
    }

    @Override
    public BCategory updateCategoryById(Long bCategoryId, BCategory bCategory) {
        return bCategoryRepository.updateBCategoryByCategoryId(bCategoryId, bCategory);
    }

    @Override
    public void deleteCategory(Long BCategoryId) {
        bCategoryRepository.deleteById(BCategoryId);
    }
}
