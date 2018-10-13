package com.workshop.back.registration.dto;


import com.workshop.back.authentication.ValidationGroup;
import com.workshop.back.registration.validations.CheckLogin;
import com.workshop.back.registration.validations.CheckPassword;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberDto {

    @CheckLogin(message = "login doit contenir 6 caracteres",
            groups = ValidationGroup.LoginGroup.class)
    private String login;
    @CheckPassword(message = "le mot de passe nest pas correct")
    private String password;
    @NotEmpty(message= "lemail est obligatoire")
    private String email;
    @NotEmpty(message= "le nom est obligatoire")
    private String lastName;
    @NotEmpty(message= "le prenom est obligatoire")
    private String firstName;
}
