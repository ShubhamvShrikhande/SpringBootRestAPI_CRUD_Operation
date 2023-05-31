package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.EmployeeService;
import com.example.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {
	@Autowired
	private EmployeeService employeeService;

	// Desine method for save or insert the Record
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return ResponseEntity.ok().body(emp);
	}

	// Desine method for fatch All the Record
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestBody Employee employee) {
		List<Employee> empl = employeeService.getAllEmployee(employee);
		return ResponseEntity.ok().body(empl);
	}

	// Desine method for fatch the using ById Record
	@GetMapping("/getBI/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee emp = employeeService.getEmployeeById(id);
		return ResponseEntity.ok().body(emp);
	}

	// Designe a method Delete a record
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);

	}

	// Desine method for update the Record
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return ResponseEntity.ok().body(emp);
	}
	// Desine method for update the Record by using ById
	@PutMapping("/updateData/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee,@PathVariable("id") Integer id) {
		Employee emp = employeeService.updateEmployeeById(employee,id);
		return ResponseEntity.ok().body(emp);
    }     
	// Desine method for find by using city
	@GetMapping("/getbycity/{city}")
    public ResponseEntity<List<Employee>> getEmployeeByCity(@PathVariable ("city") String city){
		List<Employee> employee = employeeService.getEmployeeByCity(city);
		return ResponseEntity.ok().body(employee) ;
	}
   	 
}
