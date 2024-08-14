package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_category")
@Entity
public class PostCategory {

    @Id
    @ManyToOne
    @JoinColumn(name = "post_key", nullable = false)
    private Post post;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_category_id", nullable = false)
    private PCategory pCategory;
}
