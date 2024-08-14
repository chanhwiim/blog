package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_key", nullable = false, updatable = false)
    private Long blogKey;

    @Column(name = "blog_name", nullable = false)
    private String blogName;

    @Column(name = "blog_context", nullable = false)
    private String blogContext;

    @Column(name = "notification", nullable = false)
    private String notification;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

}
