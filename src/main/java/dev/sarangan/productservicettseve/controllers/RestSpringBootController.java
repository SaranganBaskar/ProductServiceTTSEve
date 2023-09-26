package dev.sarangan.productservicettseve.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSpringBootController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
