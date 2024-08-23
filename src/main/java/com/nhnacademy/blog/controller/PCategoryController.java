package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.PCategory;
import com.nhnacademy.blog.service.PCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/p_category")
public class PCategoryController {

    private final PCategoryService pCategoryService;

    @GetMapping("/pCategories")
    public String findAll(Model model){
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
    public String findByName(Model model, @PathVariable String name){
        PCategory pCategory = pCategoryService.findByName(name);
        model.addAttribute("pCategory" ,pCategory);
        log.info("pCategory: {}", pCategory);
        return "pCategory";
    }

    @PostMapping
    public String save(Model model, PCategory category){
        PCategory pCategory = pCategoryService.save(category);
        model.addAttribute("pCategory", pCategory);
        log.info("pCategory: {}", pCategory);
        return "pCategories";
    }

    @PostMapping("/save/{parentId}")
    public String saveLowLevel(Model model, PCategory category,@PathVariable String parentId){
        PCategory pCategory = pCategoryService.saveLowLevel(category, parentId);
        model.addAttribute("pCategory", pCategory);
        return "pCategories";
    }

    @PostMapping("/update")
    public String updatePCategoryFromIdAndName(Model model, Long id, String name, PCategory category){
        PCategory pCategory = pCategoryService.updatePCategoryFromIdAndName(id, name, category);
        model.addAttribute("pCategory", pCategory);
        log.info("pCategory: {}", pCategory);
        return "pCategory";
    }

    @DeleteMapping
    public String delete(PCategory category){
        pCategoryService.delete(category);
        log.info("Class: PCategoryController.delete");
        return "pCategories";
    }
}
