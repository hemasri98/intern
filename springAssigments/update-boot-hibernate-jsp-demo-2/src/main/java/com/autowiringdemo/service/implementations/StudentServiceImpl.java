package com.autowiringdemo.service.implementations;
import com.autowiringdemo.dao.StudentDAO;
import com.autowiringdemo.entity.Student;
import com.autowiringdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        studentDAO = theStudentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student findById(int theId) {
        return studentDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
    	System.out.println(theStudent);
        studentDAO.save(theStudent);
    }
    
    @Override
    @Transactional
    public void deleteById(int theId) {
        studentDAO.deleteById(theId);
    }
}
