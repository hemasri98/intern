package com.autowiringdemo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autowiringdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
   
}

