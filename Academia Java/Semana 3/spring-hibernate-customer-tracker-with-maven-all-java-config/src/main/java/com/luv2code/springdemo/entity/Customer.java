package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
				
				//Mapeo V Cambiar
	@Column(name="nombre")
	private String name;
	
	@Column(name="apellido")
	private String lastName;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="nacionalidad")
	private String nacionality;
	
	
	
}





