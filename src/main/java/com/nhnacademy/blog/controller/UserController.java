package com.nhnacademy.blog.controller;

import com.nhnacademy.blog.domain.User;
import com.nhnacademy.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.nhnacademy.blog.exception.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
//TODO method 이름 고민
public class UserController {
    private final UserService userService;

    @GetMapping("/{userEmail}")
    public String findByUserEmail(Model model, @PathVariable String userEmail) {
        User user = userService.findByUserEmail(userEmail);
        model.addAttribute("user", user);
        log.info("User controller find by user email result is : {}", user);
        return "user";
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("User controller find all users result is : {}", users);
        return "users";
    }

    @PostMapping("/create")
    public String createUser(Model model, User user) {
        log.info("User controller create user method in : {}", user);
        User createUser = userService.createUser(user);
        model.addAttribute("user", createUser);

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, Model model, @RequestParam String userEmail, @RequestParam String password) {
        User user = userService.findByUserEmailAndPassword(userEmail, password);
        log.info("User controller find by user email result is : {}", user);

        if (user == null) {
            model.addAttribute("error", "Invalid user email or password");
            return "login";
        } else {
            session.setAttribute("user", user);
            return "redirect:/Main";
        }
    }

    @DeleteMapping
    public String deleteByUserEmail(String userEmail) {
        log.info("User controller delete user method in : {}", userEmail);
        userService.deleteByUserEmail(userEmail);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUserPasswordByUserEmailAndUserPassword(Model model, String userEmail, String password, User user) {
        User updateUser = userService.updateUserPasswordByUserEmailAndUserPassword(userEmail, password, user);
        log.info("User controller update user password by user email result is : {}", user);
        model.addAttribute("user", updateUser);
        return "Main";
    }

    @PostMapping("/logout")
    private String logout(HttpSession session) {
        session.invalidate();
        return "Login";
    }
}
