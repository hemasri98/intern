package com.autowiringdemo.dao.implementations;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.autowiringdemo.dao.EmployeeDAO;
import com.autowiringdemo.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        //System.out.println(employees);
        return employees;
    }
    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = currentSession.get(Employee.class, theId);
        //System.out.println(theEmployee);
        return theEmployee;
    }
    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);
    }
    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
