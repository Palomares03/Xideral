<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Pilotos 2023</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Formula 1</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Agregar Piloto" 
				   onclick="window.location.href='add-student-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Temporadas</th>
					<th>Accion</th>
				</tr>
				
				<c:forEach var="tempStudent" items="${LISTA_ESTUDIANTES}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<td> ${tempStudent.temporadas} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Está seguro de que desea eliminar a este piloto?'))) return false">
							Eliminar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








