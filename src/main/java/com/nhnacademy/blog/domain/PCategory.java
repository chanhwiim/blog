package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "p_category")
@Entity
public class PCategory implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_category_id", nullable = false)
    private Long pCategoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "parent_id")
    private StringBuilder parentId;
}
