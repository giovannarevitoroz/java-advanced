package com.fiap.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world") //http://localhost: 8080/hello-world
public class HelloWorldController {
    @GetMapping
    public String helloWorld() {
        return "Hello World!!!";
    }
}
