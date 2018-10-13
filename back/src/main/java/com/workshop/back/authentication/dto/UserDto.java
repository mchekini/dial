package com.workshop.back.authentication.dto;


import com.workshop.back.authentication.ValidationGroup;
import com.workshop.back.registration.validations.CheckLogin;
import com.workshop.back.registration.validations.CheckPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    @CheckLogin(message = "login doit contenir 6 caracteres",
            groups = ValidationGroup.LoginGroup.class)
    private String login;
    @CheckPassword(message = "le mot de passe nest pas correct")
    private String password;
}
