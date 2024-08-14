package com.nhnacademy.blog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.nhnacademy.blog.domain.User;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_key", nullable = false)
    private Long commentKey;

    @Column(nullable = false)
    private String comment;

    /*
     * String으로 값을 저장.
     * 최상위 댓글의 하위 댓글일 경우, 만약 최상위 댓글의 id가 1일 때: 1
     * 몇 단개 하위의 댓글일 경우: 1326
     * 제일 최근값(맨 우측) 소속으로 판단.
     * */
    @Column(name = "parent_id")
    private StringBuilder parentId;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_key", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "blog_key", nullable = false)
    private Blog blog;

}
