package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
