package com.workshop.back.registration.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckLoginValidator implements ConstraintValidator<CheckLogin, String> {
   public void initialize(CheckLogin constraint) {
   }

   public boolean isValid(String login, ConstraintValidatorContext context) {

      return login.length() >= 6;
   }
}
