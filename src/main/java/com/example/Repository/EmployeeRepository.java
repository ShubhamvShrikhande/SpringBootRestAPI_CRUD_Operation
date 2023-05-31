package com.example.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Serializable> {
	public Employee findById(Integer Id);

	@Query(value = "select * from employee_deateils c where city =?1", nativeQuery = true)
	List<Employee> findByCity(String city);

}
