package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	//Data Source para conexion a DB

	private DataSource dataSource;
	
	//Creacion del Constructor

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	//Metodo Array para retornar Pilotos

	public List<Piloto> getStudents(){
		
		//Creacion de Array

		List<Piloto> students = new ArrayList<>();

		// Sentencia SQL
		String sql = "select * from student order by last_name";
		
		//Conexion a DB y obtener sentencia sql
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// Obtener Valores
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String temporadas = myRs.getString("temporadas");

				// Creacion de nuevo objeto piloto
				Piloto tempStudent = new Piloto(id, firstName, lastName, email, temporadas);

				// Se agrega a al lista Pilotos
				students.add(tempStudent);
			}
			
			//Se define catch para posibles excepciones
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Retorna el Arrays de pilotos
		return students;

	}
	
	
	//Creacion de metodo Agregar Pilotos
	public void addStudent(Piloto theStudent) throws Exception {
		
		//Sentencia SQL para agregar nuevo registro
		String sql = "insert into student " + "(first_name, last_name, email, temporadas) " + "values (?, ?, ?, ?)";
		
		//Conexion a Db y se obtiene los datos 
		try (Connection myConn = dataSource.getConnection(); PreparedStatement ps = myConn.prepareStatement(sql);) {
			
			// Establecer parámetros
			ps.setString(3, theStudent.getFirstName());
			ps.setString(1, theStudent.getLastName());
			ps.setString(2, theStudent.getEmail());
			ps.setString(4, theStudent.getTemporadas());

			ps.execute();
		}
	}

	//Creacion de metodo Obtener Pilotos
	public Piloto getStudent(String theStudentId) throws Exception {

		Piloto theStudent = null;
		int studentId = Integer.parseInt(theStudentId);

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetStudent(myConn, studentId);
				ResultSet myRs = myStmt.executeQuery()) {

			// Recuperar datos
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String temporadas = myRs.getString("temporadas");

				// Se crea piloto con los datos obtenidos
				theStudent = new Piloto(studentId, firstName, lastName, email,temporadas);
			} else {
				
				throw new Exception("Could not find student id: " + studentId);
			}

			return theStudent;
		}
	}

	private PreparedStatement crearStatementGetStudent(Connection myConn, int studentId) throws SQLException {
		String sql = "select * from student where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, studentId);
		return ps;
	}

	//Creacion de metodo Actualizar Pilotos
	public void updateStudent(Piloto theStudent) throws Exception {

		// Sentencia sql
		String sql = "update  web_student_tracker.student set first_name=?, last_name=?, email=?, temporadas=? where id=?";

		//Conexion a DB y obtener sentencia sql
		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
			
			// Establecer parámetros
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setString(4, theStudent.getTemporadas());
			myStmt.setInt(5, theStudent.getId());
			
			myStmt.execute();
		} 
	}

	//Creacion de metodo Eliminar Pilotos
	public void deleteStudent(String theStudentId) throws Exception {

		// Sentencia SQL para eliminar registro
		String sql = "delete from student where id=?";

		//Conexion a DB y obtener sentencia sql
		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) {
			
			// Convertir id en entero
			int studentId = Integer.parseInt(theStudentId);

			// Establecer parámetros
			myStmt.setInt(1, studentId);

			myStmt.execute();
		} 
	}
}
