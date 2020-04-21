package com.autowiringdemo.service;
import java.util.List;
import com.autowiringdemo.entity.Student;

public interface StudentService {
    public List<Student> findAll();

    public Student findById(int theId);

    public Student save(Student theStudent);

    public boolean deleteById(int theId);
}
