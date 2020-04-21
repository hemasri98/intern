package com.autowiringdemo.tests;


import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.autowiringdemo.dao.EmployeeDAO;
import com.autowiringdemo.dao.implementations.EmployeeDAOHibernateImpl;
import com.autowiringdemo.entity.Employee;
import com.autowiringdemo.rest.EmployeeRestController;
import com.autowiringdemo.service.EmployeeService;
import com.autowiringdemo.service.implementations.EmployeeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	EmployeeService employeeTest;

	@Test
	void contextLoads() {
		//String x = employeeTest.deleteEmployee(5);
		//Assert.assertEquals("Deleted employee id - 5",x);
		
		
		Employee theEmployee = employeeTest.findById(2);
		String employee = theEmployee.toString();
		Assert.assertEquals("Employee [id=2, firstName=hema, lastName=dangudubiyyam, email=sri@gmail.com]", employee);
	}
	

}
