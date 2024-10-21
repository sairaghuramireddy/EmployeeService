package com.example.demo.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	public int statuscode;
	public String message;

	public ApiResponse(String number, String message) {
	}
}
