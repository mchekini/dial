package com.workshop.back.authentication;


import com.workshop.back.aspects.LogResponseTime;
import com.workshop.back.authentication.dto.UserDto;
import com.workshop.back.authentication.exceptions.InvalidPasswordException;
import com.workshop.back.authentication.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationResource {


    private final Validator validator;
    private final AuthenticationService service;

    @Inject
    public AuthenticationResource(Validator validator, AuthenticationService service) {
        this.validator = validator;
        this.service = service;
    }


    @PostMapping("/check")
    @LogResponseTime
    public Response checkAuthentication(@RequestBody(required = false) final UserDto user) {

        try {
            return Response.status(200).entity(service.checkAuthentication(user)).build();
        } catch (UserNotFoundException | InvalidPasswordException e) {
            return Response.status(401).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Erreur serveur").build();
        }

    }


}

