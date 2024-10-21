package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.util.DemoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Slf4j
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DemoUtil demoUtil;

	@GetMapping("/greet")
	public String greeting() {
		return "Hello - RESTful webservices";
	}

	@PostMapping("/employee")
	public ResponseEntity<ApiResponse> saveEmployee(@RequestBody Employee employee) {
		log.info("Request received for save employee = "+employee.getEid());
		ApiResponse apiResponse =  employeeService.saveEmployeeDetails(employee);
		log.info("Save employee response = "+demoUtil.convertObjectToJson(apiResponse));
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/employee/{empId}")
	public Employee findByEmployeeId(@PathVariable Integer empId){
		return employeeService.findByEmpId(empId);
		
	}
	
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
}
