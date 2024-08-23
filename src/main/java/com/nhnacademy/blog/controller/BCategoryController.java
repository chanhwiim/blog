package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.BCategory;
import com.nhnacademy.blog.service.BCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/BCategory")
@Slf4j
public class BCategoryController {

    private final BCategoryService bCategoryService;

    @GetMapping("/bCategories")
    public String getAllCategories(Model model) {
        List<BCategory> bCategories = bCategoryService.getAllCategories();
        log.info("Class: BCategoryController.getAllCategories size: {}", bCategories.size());
        model.addAttribute("bCategories", bCategories);
        return "bCategories";
    }

    @GetMapping("/{bCategoryId}")
    public String getCategoryById(Model model,@PathVariable Long bCategoryId) {
        BCategory bCategory = bCategoryService.getCategoryById(bCategoryId);
        model.addAttribute("bCategory", bCategory);
        return "bCategory";
    }

    @PostMapping("/bCategories")
    public String createCategory(Model model, BCategory category) {
        BCategory newCategory = bCategoryService.createCategory(category);
        model.addAttribute("bCategory", newCategory);
        return "redirect:/bCategory";
    }

    @PostMapping("/update/{bCategoryId}")
    public String updateCategoryById(Model model,@PathVariable Long bCategoryId, BCategory category) {
        BCategory bCategory = bCategoryService.updateCategoryById(bCategoryId, category);
        model.addAttribute("bCategory", bCategory);
        return "redirect:/bCategory";
    }

    @DeleteMapping
    public String deleteCategory(Long BCategoryId) {
        bCategoryService.deleteCategory(BCategoryId);
        return "redirect:/bCategories";
    }
}
