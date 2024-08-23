package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blog_category")
@Entity
public class BlogCategory implements BaseEntity{

    @Id
    @ManyToOne
    @JoinColumn(name = "blog_key", nullable = false)
    private Blog blog;

    @Id
    @ManyToOne
    @JoinColumn(name = "blog_category_id", nullable = false)
    private BCategory category;
}
