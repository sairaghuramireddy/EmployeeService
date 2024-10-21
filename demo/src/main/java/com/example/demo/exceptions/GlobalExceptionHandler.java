package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
		@ExceptionHandler(EmployeeNotFound.class)
		public ResponseEntity<ApiResponse> employeeNotFound(EmployeeNotFound employee) {
			return new ResponseEntity<>(new ApiResponse("000",employee.getMessage()),HttpStatus.OK);
		}
}
