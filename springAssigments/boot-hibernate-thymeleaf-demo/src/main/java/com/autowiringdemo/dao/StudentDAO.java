package com.autowiringdemo.dao;
import java.util.List;

import com.autowiringdemo.entity.Student;

public interface StudentDAO {
    public List<Student> findAll();

    public Student findById(int theId);

    public Student save(Student theStudent);

    public boolean deleteById(int theId);
}
