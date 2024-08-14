package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.PCategory;
import com.nhnacademy.blog.repository.PCategoryRepository;
import com.nhnacademy.blog.service.PCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PCategoryServiceImpl implements PCategoryService {

    private final PCategoryRepository pCategoryRepository;

    @Override
    public List<PCategory> findAll() {
        return pCategoryRepository.findAll();
    }

    @Override
    public PCategory findById(Long id) {
        return pCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public PCategory findByName(String name) {
        return pCategoryRepository.findByName(name);
    }

    @Override
    public PCategory save(PCategory category) {
        return pCategoryRepository.save(category);
    }

    @Override
    public PCategory saveLowLevel(PCategory category, String parentId) {
        return pCategoryRepository.savePCategoryByParentId(category, parentId);
    }

    @Override
    public PCategory updatePCategoryFromIdAndName(Long id, String name, PCategory pCategory) {
        return pCategoryRepository.updatePCategoryByCategoryIdAAndCategoryName(id, name, pCategory);
    }

    @Override
    public void delete(PCategory category) {
        pCategoryRepository.delete(category);
    }
}
