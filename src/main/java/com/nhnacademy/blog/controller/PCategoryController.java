package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.PCategory;
import com.nhnacademy.blog.service.PCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/p_category")
public class PCategoryController {

    private final PCategoryService pCategoryService;

    @GetMapping("/pCategories")
    private String findAll(Model model){
        List<PCategory> pCategories = pCategoryService.findAll();
        model.addAttribute("pCategories", pCategories);
        log.info("pCategories: {}", pCategories.size());
        return "pCategories";
    }

    @GetMapping("/id/{id}")
    private String findById(Model model, @PathVariable Long id){
        PCategory category = pCategoryService.findById(id);
        model.addAttribute("pCategory", category);
        log.info("pCategory: {}", category);
        return "pCategory";
    }

    @GetMapping("/name/{name}")
    private String findByName(Model model, @PathVariable String name){
        PCategory pCategory = pCategoryService.findByName(name);
        model.addAttribute("pCategory" ,pCategory);
        log.info("pCategory: {}", pCategory);
        return "pCategory";
    }

    @PostMapping
    private String save(Model model, PCategory category){
        PCategory pCategory = pCategoryService.save(category);
        model.addAttribute("pCategory", pCategory);
        log.info("pCategory: {}", pCategory);
        return "pCategories";
    }

    @PostMapping("/save/{parentId}")
    private String saveLowLevel(Model model, PCategory category,@PathVariable String parentId){
        PCategory pCategory = pCategoryService.saveLowLevel(category, parentId);
        model.addAttribute("pCategory", pCategory);
        return "pCategories";
    }

    @PostMapping("/update")
    private String updatePCategoryFromIdAndName(Model model, Long id, String name, PCategory category){
        PCategory pCategory = pCategoryService.updatePCategoryFromIdAndName(id, name, category);
        model.addAttribute("pCategory", pCategory);
        log.info("pCategory: {}", pCategory);
        return "pCategory";
    }

    @DeleteMapping
    private String delete(PCategory category){
        pCategoryService.delete(category);
        log.info("Class: PCategoryController.delete");
        return "pCategories";
    }
}
