package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.databaseConnection.Instructor;
import com.hibernate.databaseConnection.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			System.out.println("found instructor"+tempInstructor);
			if(tempInstructor!=null) {
				System.out.println("deleting");
				session.delete(tempInstructor);
			}
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
	}

}
