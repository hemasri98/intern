package com.autowiringdemo.dto;

import com.autowiringdemo.entity.Student;
public class StudentDTO {
	
	 private int id;
   	 private String firstName;
     private String lastName;
     private String email;

     public StudentDTO() {  
    	 
     }

     public StudentDTO(Student student) {
         this.firstName = student.getFirstName();
         this.lastName = student.getLastName();
         this.email = student.getEmail();
         this.id = student.getId();
     }
     
    public int getId() {
 		return id;
 	}

 	public void setId(int id) {
 		this.id = id;
 	}

 	public String getFirstName() {
 		return firstName;
 	}

 	public void setFirstName(String firstName) {
 		this.firstName = firstName;
 	}

 	public String getLastName() {
 		return lastName;
 	}

 	public void setLastName(String lastName) {
 		this.lastName = lastName;
 	}

 	public String getEmail() {
 		return email;
 	}

 	public void setEmail(String email) {
 		this.email = email;
 	}

}
