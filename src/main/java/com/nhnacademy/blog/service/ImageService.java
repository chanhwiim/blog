package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.Image;

import java.util.List;

public interface ImageService {

    List<Image> getImages();

    Image getImage(Long id);

    Image createImage(Image image);

    String findImageLocate(Long id);

    void deleteImage(Long id);

    Image updateImage(Image image);
}
