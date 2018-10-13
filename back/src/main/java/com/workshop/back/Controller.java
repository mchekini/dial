package com.workshop.back;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@Slf4j
public class Controller {


    @GetMapping("/test")
    public Response test() {

        return Response.status(200).entity("node 2 publish ok").build();
    }
}
