package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.databaseConnection.Instructor;
import com.hibernate.databaseConnection.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			System.out.println("creating the both object");
			Instructor tempInstructor=new Instructor("sree","hema","sree@gmail.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com/spring","coding");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("saving instructor"+tempInstructor);
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
	}

}
