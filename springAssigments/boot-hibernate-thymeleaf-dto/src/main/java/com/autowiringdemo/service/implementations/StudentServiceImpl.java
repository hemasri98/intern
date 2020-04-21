package com.autowiringdemo.service.implementations;
import com.autowiringdemo.dto.StudentDTO;
import com.autowiringdemo.entity.Student;
import com.autowiringdemo.repository.StudentRepository;
import com.autowiringdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;

	@Override
    public Student save(StudentDTO studentDto) {
          Student student = convertDtoToModel(studentDto);
          studentRepository.save(student);
          return student;
    }
	
	@Override
    public Student findById(int theId) {
		Student student = studentRepository.getOne(theId);
        return student;
	}

    @Override
    public List<Student> findAll() {
          List<Student> list = studentRepository.findAll();
          return list;
    }

    @Override
    public boolean deleteById(int id) {
    	try {
    		studentRepository.deleteById(id);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }

    public StudentDTO edit(int id) {
          Student student = studentRepository.getOne(id);
          return convertModelToDTO(student);
    }

    private Student convertDtoToModel(StudentDTO studentDto) {
          Student student = new Student();
          Student tempStudent = studentRepository.getOne(studentDto.getId());
          if (tempStudent != null) {
        	  student.setId(studentDto.getId());
          }
          student.setEmail(studentDto.getEmail());
          student.setFirstName(studentDto.getFirstName());
          student.setLastName(studentDto.getLastName());
          return student;
    }

    private StudentDTO convertModelToDTO(Student student) {
          StudentDTO studentDTO = new StudentDTO();
          studentDTO.setId(student.getId());
          studentDTO.setEmail(student.getEmail());
          studentDTO.setFirstName(student.getFirstName());
          studentDTO.setLastName(student.getLastName());
          return studentDTO;
    }
	
	
	

}
