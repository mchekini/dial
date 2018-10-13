package com.workshop.back.authentication.exceptions;

public class InvalidPasswordException extends Exception {


    public InvalidPasswordException(String message) {
        super(message);
    }
}
