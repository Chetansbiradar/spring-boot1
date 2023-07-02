package com.chetan.springboot1.controller;

//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Controller
@RestController
public class HelloController {

//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello Spring Boot World";
    }
}
