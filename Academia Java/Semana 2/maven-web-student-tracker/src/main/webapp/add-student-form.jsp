<!DOCTYPE html>
<html>

<head>
	<title>Agregar Piloto</title>

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
		<h3>Agregar Piloto</h3>
		
		<form action="StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label>Temporadas:</label></td>
						<td><input type="text" name="temporadas" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
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











