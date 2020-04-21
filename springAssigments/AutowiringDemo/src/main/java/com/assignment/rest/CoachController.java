package com.assignment.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
	
    @GetMapping("/hello")
    public String sayhello() {
    	System.out.println("khgki");
    	return "hello";
    }
   
}
