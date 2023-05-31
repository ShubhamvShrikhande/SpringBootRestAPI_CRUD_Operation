package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.EmployeeRepository;
import com.example.custome.exception.BusinessException;
import com.example.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee ep = employeeRepository.save(employee);
		return ep;// employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee(Employee employee) {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee em = employeeRepository.findById(id);
		if (em != null) {
			return em;
		} else {
			throw new BusinessException();
		}

	}

	@Override
	public Employee updateEmployeeById(Employee employee, Integer id) {
		Employee ep = employeeRepository.findById(id);
		if (employee != null) {
			employee.setFirstName(ep.getFirstName());
			employee.setCity(ep.getCity());

			return saveEmployee(employee);
		} else {
			return saveEmployee(ep);
		}

	}

	@Override
	public List<Employee> getEmployeeByCity(String city) {
		List<Employee> employee = employeeRepository.findByCity(city);

		return employee;
	}

}
