package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.Image;
import com.nhnacademy.blog.repository.ImageRepository;
import com.nhnacademy.blog.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public String findImageLocate(Long id) {
        return getImage(id).getLocate();
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }
}
