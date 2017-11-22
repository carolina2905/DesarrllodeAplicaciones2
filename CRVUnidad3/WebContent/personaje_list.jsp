<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Personaje List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="PersonajeController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="PersonajeReport">Imprimir Reporte</a>
			</th>
			<th>Id </th>
			<th>Posicion Actual</th>
			<th>Velocidad</th>
			<th>Estado</th>
			
		</tr>
		<c:forEach var="personaje" items="${personajes}">
			<tr>
				<td>
					<form action="PersonajeController">
						<input type="hidden" name="id" value="${personaje.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${personaje.id}</td>
			<td>${personaje.posicion_actual}</td>
			<td>${personaje.velocidad}</td>
			<td>${personaje.estado}</td>
			
			</tr>
		</c:forEach>
	</table>

</body>
</html>