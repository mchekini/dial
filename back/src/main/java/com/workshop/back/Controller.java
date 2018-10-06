package com.workshop.back;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class Controller {



    @GetMapping("/test")
    public Response test(){
        return Response.status(200).entity("node 2 ok").build();
    }
}
