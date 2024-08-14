package com.nhnacademy.blog.repository;

import com.nhnacademy.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String email);

    User findUserByUserEmailAndPassword(String email, String password);

    User updateUserByUserEmailAndPassword(String email, String password, User user);
}
