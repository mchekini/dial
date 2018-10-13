package com.workshop.back;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@ControllerAdvice
public class Controller {

    @GetMapping("/test")
    public String test() {

        log.info("test 2");
        return "test";
    }
}
