package com.autowiringdemo.rest;

import java.util.List;
import java.util.Map;

import com.autowiringdemo.entity.Employee;
import com.autowiringdemo.service.EmployeeService;

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
@RequestMapping("/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
    @GetMapping("/list")
    public String findAll(Model model) {
    	List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("empList", employeeList);
        return "employeeList";

    }
//    @GetMapping("/id/{employeeId}")
//    public String getEmployee(@PathVariable int employeeId, Model model) {
//        Employee theEmployee = employeeService.findById(employeeId);
//        model.addAttribute("findEmp", theEmployee);
//        if (theEmployee == null) {
//            return "notFound";
//        }
//        return "findEmployee";
//    }
    
    @GetMapping("/find")
    public String findEmployee(Map<String, Object> model) {
		  model.put("findEmp", new Employee());
	      return "findid";
    }
	@PostMapping("/get/id")
	public String getEmployee(@RequestParam("id") int employeeId, Model model) {
	    Employee theEmployee = employeeService.findById(employeeId);
	    model.addAttribute("findEmp", theEmployee);
	    if (theEmployee == null) {
	        return "notFound";
	    }
	    return "findEmployee";
	} 
    
    
    
    @GetMapping("/create")
    public String create(Map<String, Object> model) {
          model.put("employee", new Employee());
          return "addEmployee";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {
        theEmployee.setId(0);
        //System.out.println(theEmployee);
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    
    
    @GetMapping("/edit")
    public String edit(Map<String, Object> model) {
          model.put("employee", new Employee());
          return "editEmployee";
    }
    @PostMapping("/edit/id")
    public String editEmployee(@ModelAttribute("employee") Employee theEmployee) {
    	int employeeId = theEmployee.getId();
    	Employee oldDetails = employeeService.findById(employeeId);
    	if(oldDetails != null) {
	        oldDetails.setFirstName(theEmployee.getFirstName());
	        oldDetails.setLastName(theEmployee.getLastName());
	        oldDetails.setEmail(theEmployee.getEmail());
	        employeeService.save(oldDetails);
	        return "redirect:/employees/list";
        }
    	return "notFound";
    }
    
    
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee theEmployee) {
//        employeeService.save(theEmployee);
//        return theEmployee;
//    }
    
    
    
    
    
    
    @GetMapping("/delete")
    public String delete(Map<String, Object> model) {
          model.put("deleteEmp", new Employee());
          return "enterid";
    }
    @PostMapping("/delete/id")
    public String deleteEmployee(@RequestParam("id") int employeeId, Model model) {
        Employee theEmployee = employeeService.findById(employeeId);
        model.addAttribute("deleteEmp", theEmployee);
        if (theEmployee == null) {
            return "notFound";
        }
        employeeService.deleteById(employeeId);
        return "deleteEmployee";
    }
}
