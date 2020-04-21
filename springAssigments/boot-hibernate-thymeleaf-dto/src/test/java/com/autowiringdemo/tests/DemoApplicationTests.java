package com.autowiringdemo.tests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
		Boolean isPresent = studentTest.deleteById(100);
		Assert.assertEquals(false,isPresent);
		
		
		Student theStudent = studentTest.findById(2);
		String student = theStudent.toString();
		Assert.assertEquals("Student [id=2, firstName=Sailaja, lastName=sree, email=sailaja@gmail.com]", student);
	}
	

}

