package com.nhnacademy.blog.service;

import com.nhnacademy.blog.domain.User;

import java.util.List;

public interface UserService {
    User findByUserEmail(String userEmail);

    List<User> findAll();

    User createUser(User user);

    User findByUserEmailAndPassword(String userEmail, String password);

    void deleteByUserEmail(String userEmail);

    User updateUserPasswordByUserEmailAndUserPassword(String userEmail, String password, User user);

}
