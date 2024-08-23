package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_category")
public class BCategory implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_category_id", nullable = false)
    private Long bCategoryId;

    @Column(name = "blog_category_name", nullable = false)
    private String blogCategoryName;

    /*
    * String으로 값을 저장.
    * 최상위 카테고리의 하위 카테고리일 경우, 만
    * 약 최상위 카테고리의 id가 1일 때: 1
    * 몇 단개 하위의 카테고리일 경우: 1326
    * 제일 최근값(맨 우측) 소속으로 판단.
    * */
    @Column(name = "parent_id")
    private String parentId;
}
