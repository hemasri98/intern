package com.springboot.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World! Time on server..." + LocalDateTime.now(); 
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "run 5k"; 
	}

}
