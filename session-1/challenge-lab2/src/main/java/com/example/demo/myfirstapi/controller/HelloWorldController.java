package com.example.demo.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //
public class HelloWorldController {
    @GetMapping("/hello")
    public String sayHello() {
        return customGreeting; // Now returns the custom message
    }

    @GetMapping("greet/{name}")
    public String greetUser(@PathVariable String name){
        return "Greetings," + name + "!";
    }

    @Value("${app.greeting.message}") // Inject value from application.properties
    private String customGreeting;

    @GetMapping("/greeting")
    public String greetWithParam(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/calculate/sum")
    public String sumNumbers(
            @RequestParam("num1") int number1,
            @RequestParam("num2") int number2) {
        int sum = number1 + number2;
        return "The sum of " + number1 + " and " + number2 + " is " + sum;
    }
}
