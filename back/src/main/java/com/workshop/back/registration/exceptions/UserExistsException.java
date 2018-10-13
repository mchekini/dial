package com.workshop.back.registration.exceptions;

public class UserExistsException extends Exception {

    public UserExistsException(String message) {
        super(message);
    }
}
