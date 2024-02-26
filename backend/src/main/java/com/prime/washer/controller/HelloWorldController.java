package com.prime.washer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hi")
//    @ResponseBody
    String hi() {
        return ("Hello, World");
    }
}
