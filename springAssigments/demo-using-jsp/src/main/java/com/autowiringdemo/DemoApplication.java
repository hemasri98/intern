package com.autowiringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.autowiringdemo.dao.implementations.EmployeeDAOHibernateImpl;
import com.autowiringdemo.rest.EmployeeRestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
