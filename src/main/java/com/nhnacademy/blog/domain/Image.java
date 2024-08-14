package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Long imageId;

    @Column(name = "image_root", nullable = false)
    private String imageRoot;

    @Column(nullable = false)
    private String locate;

    // 확장자
    @Column(nullable = false)
    private String type;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Blog blog;
}