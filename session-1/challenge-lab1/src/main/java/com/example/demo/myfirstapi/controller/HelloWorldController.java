package com.example.demo.myfirstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //
public class HelloWorldController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, Spring Boot Learners!";
    }

    @GetMapping("greet/{name}")
    public String greetUser(@PathVariable String name){
        return "Greetings," + name + "!";
    }
}
