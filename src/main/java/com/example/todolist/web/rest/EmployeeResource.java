package com.example.todolist.web.rest;

import com.example.todolist.domain.Employee;
import com.example.todolist.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class EmployeeResource {

	private final EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.save(employee);
		return ResponseEntity.ok(employee1);
	}

	@GetMapping("/employees/list")
	public ResponseEntity<List<Employee>> getEmployeeList() {
		List<Employee> employeeList = employeeService.employeeList();
		return ResponseEntity.ok(employeeList);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable Long id) throws Exception {
		if (id == null) {
			throw new Exception("Employee not exist with id: " + id);
		}
		Optional<Employee> optionalEmployee = employeeService.getById(id);
		return ResponseEntity.ok(optionalEmployee.get());
	}

	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
		if (id == null) {
			throw new Exception("Employee not exist with id: " + id);
		}
		Employee employee1 = employeeService.getById(id).orElseThrow(() -> new Exception("Employee not exist width id " + id));
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setCountry(employee.getCountry());
		employee1.setAddress(employee.getAddress());
		employee1.setPhoneNumber(employee.getPhoneNumber());

		return ResponseEntity.ok(employee1);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity deleteEmployee(@PathVariable Long id){
		employeeService.delete(id);
		return ResponseEntity.ok("Employee deleted");
	}
}
