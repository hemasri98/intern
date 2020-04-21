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
import com.autowiringdemo.entity.Student;
import com.autowiringdemo.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	StudentService studentTest;

	@Test
	void contextLoads() {
		//String x = studentTest.deleteStudent(5);
		//Assert.assertEquals("Deleted student id - 5",x);
		
		
		Student theStudent = studentTest.findById(2);
		String student = theStudent.toString();
		Assert.assertEquals("Student [id=2, firstName=Sailaja, lastName=sree, email=sailaja@gmail.com]", student);
	}
	

}

