<!DOCTYPE html>
<html>

<head>
	<title>Actualizar Datos</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Formula 1 2023</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar Datos</h3>
		
		<form action="StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="studentId" value="${THE_STUDENT.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="firstName" 
								   value="${THE_STUDENT.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_STUDENT.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_STUDENT.email}" /></td>
					</tr>
					
					<tr>
						<td><label>Temporadas:</label></td>
						<td><input type="text" name="temporadas" 
								   value="${THE_STUDENT.temporadas}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="StudentControllerServlet">Volver a la Lista</a>
		</p>
	</div>
</body>

</html>











