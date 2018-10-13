package com.workshop.back.registration.exceptions;

import lombok.Data;

import java.util.List;

@Data
public class ValidationException  extends  Exception{

    private List<String> errors;

    public ValidationException(List<String> errors) {
        super();
        this.errors = errors;
    }
}
