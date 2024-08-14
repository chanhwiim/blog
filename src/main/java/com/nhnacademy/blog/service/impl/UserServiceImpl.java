package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.User;
import com.nhnacademy.blog.repository.UserRepository;
import com.nhnacademy.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserEmailAndPassword(String userEmail, String password) {
        return userRepository.findUserByUserEmailAndPassword(userEmail, password);
    }

    @Override
    public void deleteByUserEmail(String userEmail) {
        userRepository.delete(findByUserEmail(userEmail));
    }

    @Override
    public User updateUserPasswordByUserEmailAndUserPassword(String userEmail, String password, User user) {
        return userRepository.updateUserByUserEmailAndPassword(userEmail, password, user);
    }
}
