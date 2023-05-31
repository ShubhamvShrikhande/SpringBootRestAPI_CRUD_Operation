package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);

	public void deleteEmployee(Integer id);

	public List<Employee> getAllEmployee(Employee employee);

	public Employee getEmployeeById(Integer id);

	public Employee updateEmployeeById(Employee employee, Integer id);

	public List<Employee> getEmployeeByCity(String city);

}
