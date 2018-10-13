package com.workshop.back.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import static javax.persistence.EnumType.STRING;

@Entity
@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    private String login;
    private String password;
    private String email;
    @Enumerated(STRING)
    private Role role;
    private String lastName;
    private String firstName;
}
