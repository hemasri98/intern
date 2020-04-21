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
    public Student save(Student theStudent) {
        Student student = studentDAO.save(theStudent);
        return student;
    }
    
    @Override
    @Transactional
    public boolean deleteById(int theId) {
        if(studentDAO.deleteById(theId))
        	return true;
        return false;
    }
}
