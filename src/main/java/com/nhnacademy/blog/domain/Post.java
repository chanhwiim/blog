package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
@Entity
public class Post implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_key", nullable = false)
    private Long postKey;

    @Column(nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;
}
