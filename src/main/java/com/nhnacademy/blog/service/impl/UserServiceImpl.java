package com.nhnacademy.blog.service.impl;

import com.nhnacademy.blog.domain.User;
import com.nhnacademy.blog.exception.UserNotFoundException;
import com.nhnacademy.blog.exception.UsersNotExistException;
import com.nhnacademy.blog.repository.UserRepository;
import com.nhnacademy.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUserEmail(String userEmail) {
        User user = userRepository.findByUserEmail(userEmail);
        if (user == null) {
            log.error("Class: UserServiceImpl method: findByUserEmail returned null");
            throw new UserNotFoundException(userEmail);
        }
        log.info("Found user with email: {}", userEmail);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            log.error("Class: UserServiceImpl method: findAll returned empty list");
            throw new UsersNotExistException();
        }
        log.info("Found {} users", userList.size());
        return userList;
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
        User updateUser = userRepository.updateUserByUserEmailAndPassword(userEmail, password, user);
        if (findByUserEmailAndPassword(userEmail, password) == null) {
            log.error("Class: UserServiceImpl method: updateUserPasswordByUserEmailAndPassword returned null");
            throw new UserNotFoundException(userEmail, password);
        }
        return updateUser;
    }
}
