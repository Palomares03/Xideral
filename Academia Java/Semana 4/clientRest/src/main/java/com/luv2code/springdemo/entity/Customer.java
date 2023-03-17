package com.luv2code.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String nacionalidad;
	
}





