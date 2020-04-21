package com.autowiringdemo.dao.implementations;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.autowiringdemo.dao.StudentDAO;
import com.autowiringdemo.entity.Student;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class StudentDAOHibernateImpl implements StudentDAO {
    private EntityManager entityManager;
    @Autowired
    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Student> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
        List<Student> students = theQuery.getResultList();
        //System.out.println(students);
        return students;
    }
    @Override
    public Student findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student theStudent = currentSession.get(Student.class, theId);
        //System.out.println(theStudent);
        return theStudent;
    }
    @Override
    public Student save(Student theStudent) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theStudent);
        return theStudent;
    }
    @Override
    public boolean deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
        theQuery.setParameter("studentId", theId);
        theQuery.executeUpdate();
        Student theStudent = findById(theId);
        if(theStudent != null) {
        	return true;
        }
        return false;
    }
}
