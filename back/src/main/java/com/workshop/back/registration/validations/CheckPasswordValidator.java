package com.workshop.back.registration.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, String> {
   public void initialize(CheckPassword constraint) {
   }

   public boolean isValid(String password, ConstraintValidatorContext context) {

      return password.length() > 5 && password.contains("/");
   }
}
