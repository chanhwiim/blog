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
    private PCategory save(PCategory category){
        return pCategoryService.save(category);
    }

    @PostMapping("/save/{parentId}")
    private PCategory saveLowLevel(PCategory category,@PathVariable String parentId){
        return pCategoryService.saveLowLevel(category, parentId);
    }

    @PostMapping("/update")
    private PCategory updatePCategoryFromIdAndName(Long id, String name, PCategory category){
        return pCategoryService.updatePCategoryFromIdAndName(id, name, category);
    }

    @DeleteMapping
    private void delete(PCategory category){
        pCategoryService.delete(category);
    }
}
