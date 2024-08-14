package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.User;
import com.nhnacademy.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.nhnacademy.blog.exception.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{userEmail}")
    public User findByUserEmail(@PathVariable String userEmail) {
        User user = userService.findByUserEmail(userEmail);
        if (user == null) {
            throw new UserNotFoundException(userEmail);
        }
        log.info("User controller find by user email result is : {}", user);
        return user;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        List<User> users = userService.findAll();
        if (users == null) {
            throw new UsersNotExistException();
        }

        log.info("User controller find all users result is : {}", users);
        return users;
    }

    @PostMapping("/create")
    public User createUser(User user) {
        log.info("User controller create user method in : {}", user);
        return userService.createUser(user);
    }

    @GetMapping("/login")
    public User findByUserEmailAndPassword(String userEmail, String password) {
        User user = userService.findByUserEmailAndPassword(userEmail, password);
        if (user == null) {
            throw new UserNotFoundException(userEmail, password);
        }

        log.info("User controller find by user email result is : {}", user);
        return user;
    }

    @DeleteMapping
    public void deleteByUserEmail(String userEmail) {
        log.info("User controller delete user method in : {}", userEmail);
        userService.deleteByUserEmail(userEmail);
    }

    @PostMapping("/update")
    public User updateUserPasswordByUserEmailAndUserPassword(String userEmail, String password, User user) {
        if (userService.findByUserEmailAndPassword(userEmail, password) == null) {
            throw new UserNotFoundException(userEmail, password);
        } else {

            log.info("User controller update user password by user email result is : {}", user);
            return userService.updateUserPasswordByUserEmailAndUserPassword(userEmail, password, user);
        }
    }
}
