package com.example.todolist.service;

import com.example.todolist.domain.Employee;
import com.example.todolist.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> employeeList() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getById(Long id) {
		return employeeRepository.findById(id);
	}

	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}
}
