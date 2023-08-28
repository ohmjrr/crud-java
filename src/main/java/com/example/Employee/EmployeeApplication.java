package com.example.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.dataobject.Employee;
import com.example.Employee.dataobject.EmployeeRepo;

@RestController
@SpringBootApplication
public class EmployeeApplication {

	@Autowired
	private EmployeeRepo repo;

	@RequestMapping("/")
	String home (){
		return "สวัสดีค้าบท่านสมาชิก";
	}

	@RequestMapping("/api/allemployees")
	public List<Employee> allemployees(){
		return repo.getAll();
	}

	@RequestMapping("/api/count")
	public int countEmployee(){
		return repo.countEmployees();
	}

	@RequestMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable String id){
		return repo.getEmployee(id);
	}

	@RequestMapping("/api/department/{dept}")
	public List<Employee> getEmployeesByDept(@PathVariable String dept){
		return repo.getEmployeesByDept(dept);
	}

	@RequestMapping(value = "/api/post", method = RequestMethod.POST)
	public String post(@RequestBody Employee e){
		System.out.println(e);
		return repo.postEmployee(e);
	}

	@RequestMapping(value = "/api/employee/{id}", method = RequestMethod.PUT)
	public String put(@PathVariable String id, @RequestBody Employee updatedEmployee) {
    Employee updateEmployee = repo.getEmployee(id);
    
    if (updateEmployee != null) {
        updatedEmployee.setId(updateEmployee.getId()); 
        return repo.putEmployee(updatedEmployee);
    }
    	return null; 
	}

	@RequestMapping(value = "/api/employee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable String id) {
    	return repo.deleteEmployee(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
