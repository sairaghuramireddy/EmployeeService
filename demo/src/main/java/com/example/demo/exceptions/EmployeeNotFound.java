package com.example.demo.exceptions;

public class EmployeeNotFound extends RuntimeException {

	public EmployeeNotFound(String message) {
		super(message);
	}
}
