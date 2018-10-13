package com.workshop.back.authentication.dto;


import com.workshop.back.authentication.ValidationGroup;
import com.workshop.back.authentication.validations.CheckLogin;
import com.workshop.back.authentication.validations.CheckPassword;
import lombok.Data;

@Data
public class UserDto {


    @CheckLogin(message = "login doit contenir 6 caracteres",
            groups = ValidationGroup.LoginGroup.class)
    private String login;
    @CheckPassword(message = "le mot de passe nest pas correct")
    private String password;
}
