package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
//Ruta de Servlet
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;
		
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// Tipos de Metodos
			switch (theCommand) {
			
			case "LIST":
				listStudents(request, response);
				break;
				
			case "ADD":
				addStudent(request, response);
				break;
				
			case "LOAD":
				loadStudent(request, response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
			
			case "DELETE":
				deleteStudent(request, response);
				break;
				
			default:
				listStudents(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	
	//Metodo Borrar Piloto
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// Lectura del id
		String theStudentId = request.getParameter("studentId");
		
		// Eliminar Piloto
		studentDbUtil.deleteStudent(theStudentId);
		
		// Es enviado de vuelta
		listStudents(request, response);
	}

	//Metodo Actualizar Piloto
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// Lectura de informacion del piloto
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String temporadas = request.getParameter("temporadas");
		
		// Creacion de nuevo Piloto
		Piloto theStudent = new Piloto(id, firstName, lastName, email, temporadas);
		
		// perform update on database
		studentDbUtil.updateStudent(theStudent);
		
		// Es enviado de vuelta
		listStudents(request, response);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// get student from database (db util)
		Piloto theStudent = studentDbUtil.getStudent(theStudentId);
		
		// place student in the request attribute
		request.setAttribute("THE_STUDENT", theStudent);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);		
	}

	//Metodo Agregar Piloto
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Lectura de informacion del piloto
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");		
		String temporadas = request.getParameter("temporadas");
		
		// create a new student object
		Piloto theStudent = new Piloto(firstName, lastName, email, temporadas);
		
		// add the student to the database
		studentDbUtil.addStudent(theStudent);
				
		// send back to main page (the student list)
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get students from db util
		List<Piloto> students = studentDbUtil.getStudents();
		
		// add students to the request
		request.setAttribute("LISTA_ESTUDIANTES", students);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

}













