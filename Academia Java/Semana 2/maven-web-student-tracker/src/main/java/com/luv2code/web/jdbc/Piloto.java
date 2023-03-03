package com.luv2code.web.jdbc;

public class Piloto {
	
	//Declaracion de variables

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String temporadas;
	
	//Creacion de Metodos Constructores

	public Piloto(String Apellido, String email,String Nombre,String temporadas) {
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.email = email;
		this.temporadas = temporadas;
	}

	public Piloto(int id, String Nombre, String Apellido, String email, String temporadas) {
		this.id = id;
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.email = email;
		this.temporadas = temporadas;
	}
	
	//Declaracion de Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return nombre;
	}

	public void setFirstName(String firstName) {
		this.nombre = firstName;
	}

	public String getLastName() {
		return apellido;
	}

	public void setLastName(String lastName) {
		this.apellido = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(String temporadas) {
		this.temporadas = temporadas;
	}
	
	//Retorna Valores

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + nombre + ", lastName=" + apellido + ", email=" + email + ", Temporadas =" + temporadas +"]";
	}	
}
