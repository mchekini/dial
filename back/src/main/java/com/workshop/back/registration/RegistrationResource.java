package com.workshop.back.registration;

import com.workshop.back.authentication.exceptions.InvalidPasswordException;
import com.workshop.back.authentication.exceptions.UserNotFoundException;
import com.workshop.back.registration.dto.MemberDto;
import com.workshop.back.registration.exceptions.UserExistsException;
import com.workshop.back.registration.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class RegistrationResource {


    private final RegistrationService service;

    @Autowired
    public RegistrationResource(RegistrationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Response register(@RequestBody final MemberDto member) {

        try {
            return Response.status(200).entity(service.register(member)).build();
        }catch (ValidationException e){
            return Response.status(400).entity(e.getErrors()).build();
        }catch (UserExistsException e){
            return Response.status(401).entity(e.getMessage()).build();
        }catch(Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }

    }
}
