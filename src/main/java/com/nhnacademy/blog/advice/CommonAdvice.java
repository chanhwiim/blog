package com.nhnacademy.blog.advice;

import com.nhnacademy.blog.exception.CreatePostFailedException;
import com.nhnacademy.blog.exception.UpdateIsFailedException;
import com.nhnacademy.blog.exception.UserNotFoundException;
import com.nhnacademy.blog.exception.UsersNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(final UserNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UsersNotExistException.class)
    public String handleUsersNotExistException(final UsersNotExistException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UpdateIsFailedException.class)
    public String handleUpdateIsFailedException(final UpdateIsFailedException e) {
        return e.getMessage();
    }

    @ExceptionHandler(CreatePostFailedException.class)
    public String handleCreatePostFailedException(final CreatePostFailedException e) {
        return e.getMessage();
    }
}
