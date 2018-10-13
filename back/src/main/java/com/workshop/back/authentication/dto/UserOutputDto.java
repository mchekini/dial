package com.workshop.back.authentication.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {
    private String firstName;
    private String lastName;
    private String role;
    private String login;
}
