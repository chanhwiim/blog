package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.BCategory;
import com.nhnacademy.blog.service.BCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/BCategory")
@Slf4j
public class BCategoryController {

    private final BCategoryService bCategoryService;

    private String getAllCategories(Model model) {
        List<BCategory> bCategories = bCategoryService.getAllCategories();
        model.addAttribute("bCategories", bCategories);
        return "bCategories";
    }

    private String getCategoryById(Model model, Long BCategoryId) {
        BCategory bCategory = bCategoryService.getCategoryById(BCategoryId);
        model.addAttribute("bCategory", bCategory);
        return "bCategory";
    }

    private String createCategory(Model model, BCategory category) {
        BCategory newCategory = bCategoryService.createCategory(category);
        model.addAttribute("bCategory", newCategory);
        return "redirect:/bCategory";
    }

    private String updateCategoryById(Model model, Long bCategoryId, BCategory category) {
        bCategoryService.updateCategoryById(bCategoryId, category);
        return "redirect:/bCategory";
    }

    private String deleteCategory(Model model, Long BCategoryId) {
        bCategoryService.deleteCategory(BCategoryId);
        return "redirect:/bCategories";
    }
}
