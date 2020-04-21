package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.databaseConnection.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			//creating
			System.out.println("creating the student object");
//			Student tempStudent1=new Student("hema","sri","hemasree@gmail.com");
//			Student tempStudent2=new Student("hema","sree","sree@gmail.com");
			Student tempStudent3=new Student("Dangudubiyyam","hema","hemasree@gmail.com");
			//Student tempStudent2=new Student("hema","sree","sree@gmail.com");
			session.beginTransaction();
			System.out.println("saving student");
			session.save(tempStudent3);
			//session.save(tempStudent2);
			session.getTransaction().commit();
			System.out.println("done");

			//reading
			session.beginTransaction();
			int id = tempStudent3.getId();
			Student myStudent = session.get(Student.class, id);
			System.out.print(myStudent);
			session.getTransaction().commit();

			//quering
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			for(Student tempStudent : students) {
				System.out.println(tempStudent);
			}
			session.getTransaction().commit();

			//updating
			session.beginTransaction();
			int studentId = 2;
			Student myStudent1 = session.get(Student.class, studentId);
			System.out.print("before update: " + myStudent1);
			myStudent1.setFirstName("Sailaja");
			session.createQuery("update Student set email='sailaja@gmail.com' where id=2").executeUpdate();
			session.getTransaction().commit();

			//deleting
			session.beginTransaction();
			int studentId1 = 3;
			Student myStudent2 = session.get(Student.class, studentId1);
			session.delete(myStudent2);
			session.getTransaction().commit();
			
			
			
			
		}
		finally {
			factory.close();
		}
	}

}
