package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ApiResponse saveEmployeeDetails(Employee employee) {
		log.info("Save employee request received @Service");
		ApiResponse apiResponse = null;
		Employee empObj = employeeRepository.save(employee);


		if(empObj.getId()>0){

			apiResponse = ApiResponse.builder()
									 .statuscode(Integer.parseInt("000"))
									 .message("Employee Details Saved successfully")
									 .build();
			
		}else {
			apiResponse = ApiResponse.builder()
									 .statuscode(Integer.parseInt("9001"))
									 .message("Unable to save employee")
									 .build();
		}

        return apiResponse;
    }

	@Override
	public List<Employee> getallEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByEmpId(Integer empId) {

		Optional<Employee> optEmployee = employeeRepository.findByEid(empId);

		if(optEmployee.isPresent()) {
			return optEmployee.get();
		}else {
			throw new EmployeeNotFound("Employee Not Found!");
		}
	}

	@Override
	public String updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Details Updated successfully";
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee Details Deleted successfully";
	}

	

}
