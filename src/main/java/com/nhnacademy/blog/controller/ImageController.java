package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.Image;
import com.nhnacademy.blog.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/image")
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/images")
    public String getImages(Model model){
        List<Image> images = imageService.getImages();
        log.info("List<getImage> size is :{}", images.size());
        model.addAttribute("images", images);
        return "images";
    }

    @GetMapping("/{id}")
    public String getImage(Model model,@PathVariable Long id){
        Image image = imageService.getImage(id);
        log.info("Image id is : {}", image.getImageId());
        model.addAttribute("image", image);
        return "image";
    }

    @PostMapping("/create")
    public String createImage(Model model, Image image) {
        Image createdImage = imageService.createImage(image);
        log.info("create image id is : {}", createdImage.getImageId());
        model.addAttribute("image", createdImage);
        return "images";
    }

    @GetMapping("/locate")
    public String findImageLocate(Model model, Long id) {
        String locate = imageService.findImageLocate(id);
        log.info("image locate is : {}", locate);
        model.addAttribute("imageLocate", locate);
        return "image";
    }

    @DeleteMapping
    public String deleteImage(Long id) {
        imageService.deleteImage(id);
        return "redirect:/image";
    }

    @PostMapping("/update")
    public String updateImage(Model model, Image image) {
        Image updatedImage = imageService.updateImage(image);
        log.info("update image id is : {}", updatedImage.getImageId());
        model.addAttribute("image", updatedImage);
        return "image";
    }
}