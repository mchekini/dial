package com.workshop.back.persistence.entity;


import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import static javax.persistence.EnumType.STRING;

@Entity
@Data
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
