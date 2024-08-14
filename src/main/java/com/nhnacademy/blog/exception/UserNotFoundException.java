package com.nhnacademy.blog.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, String message2) {
        super(String.format("%s, %s를 가지는 user를 찾을 수 없습니다.", message, message2));
    }
}
