package main.java.com.repository;


import java.util.List;

import main.java.com.dao.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

	List<Employee> findAll();
	Employee findById(Integer id);
}
