package com.nhnacademy.blog.advice;

import com.nhnacademy.blog.controller.UserController;
import com.nhnacademy.blog.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(basePackageClasses = UserController.class)
public class CommonAdvice {

//패키지를 구분해서 controller advice를 잡는게 코드 구현상 보기 편하다. 굳이 하나로 뭉칠 필요성은 없다.

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(final UserNotFoundException e) {
        log.error("user not found exception : {}",e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(UsersNotExistException.class)
    public String handleUsersNotExistException(final UsersNotExistException e) {
        return e.getMessage();
    }

    @ExceptionHandler(PostNotFoundException.class)
    public String handleUpdateIsFailedException(final PostNotFoundException e) {
        return e.getMessage();
    }
}
