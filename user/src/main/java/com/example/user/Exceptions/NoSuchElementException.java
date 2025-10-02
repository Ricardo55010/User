package com.example.user.Exceptions;

public class NoSuchElementException extends  RuntimeException {
    public NoSuchElementException(String errorMessage) {
        super(errorMessage);
    }
}
