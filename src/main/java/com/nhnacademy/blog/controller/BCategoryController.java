package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.BCategory;
import com.nhnacademy.blog.service.BCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/BCategory")
@Slf4j
public class BCategoryController {

    private final BCategoryService bCategoryService;

    @GetMapping("/bCategories")
    private String getAllCategories(Model model) {
        List<BCategory> bCategories = bCategoryService.getAllCategories();
        log.info("Class: BCategoryController.getAllCategories size: {}", bCategories.size());
        model.addAttribute("bCategories", bCategories);
        return "bCategories";
    }

    @GetMapping("/{bCategoryId}")
    private String getCategoryById(Model model,@PathVariable Long bCategoryId) {
        BCategory bCategory = bCategoryService.getCategoryById(bCategoryId);
        model.addAttribute("bCategory", bCategory);
        return "bCategory";
    }

    @PostMapping("/bCategories")
    private String createCategory(Model model, BCategory category) {
        BCategory newCategory = bCategoryService.createCategory(category);
        model.addAttribute("bCategory", newCategory);
        return "redirect:/bCategory";
    }

    @PostMapping("/update/{bCategoryId}")
    private String updateCategoryById(Model model,@PathVariable Long bCategoryId, BCategory category) {
        BCategory bCategory = bCategoryService.updateCategoryById(bCategoryId, category);
        model.addAttribute("bCategory", bCategory);
        return "redirect:/bCategory";
    }

    @DeleteMapping
    private String deleteCategory(Long BCategoryId) {
        bCategoryService.deleteCategory(BCategoryId);
        return "redirect:/bCategories";
    }
}
