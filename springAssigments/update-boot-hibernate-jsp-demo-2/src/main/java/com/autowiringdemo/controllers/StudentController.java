package com.autowiringdemo.controllers;

import java.util.List;
import java.util.Map;
import com.autowiringdemo.entity.Student;
import com.autowiringdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }
    @GetMapping("/list")
    public String findAll(Model model) {
    	List<Student> studentList = studentService.findAll();
        model.addAttribute("stuList", studentList);
        return "studentList";

    }

    @GetMapping("/find")
    public String findStudent(Map<String, Object> model) {
		  model.put("findStu", new Student());
	      return "findid";
    }
	@PostMapping("/get/id")
	public String getStudent(@RequestParam("id") int studentId, Model model) {
		Student theStudent = studentService.findById(studentId);
	    model.addAttribute("findStu", theStudent);
	    if (theStudent == null) {
	        return "notFound";
	    }
	    return "findStudent";
	} 

    @GetMapping("/create")
    public String create(Map<String, Object> model) {
          model.put("student", new Student());
          return "addStudent";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student theStudent) {
        //System.out.println(theStudent);
        studentService.save(theStudent);
        return "redirect:/students/list";
    }
    
    @GetMapping("/edit/id")
    public String updateStudent(@RequestParam("id") int studentId, Model model) {
    	Student oldDetails = studentService.findById(studentId);
    	model.addAttribute("student", oldDetails);
    	return "addStudent";
    }
    
    @GetMapping("/delete/id")
    public String deleteStudent(@RequestParam("id") int studentId, Model model) {
    	Student theStudent = studentService.findById(studentId);
        model.addAttribute("deleteStu", theStudent);
        studentService.deleteById(studentId);
        return "redirect:/students/list";
    }
    
    
}
