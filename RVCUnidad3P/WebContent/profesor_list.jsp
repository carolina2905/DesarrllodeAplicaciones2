<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Profesor List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="ProfesorController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="ProfesorReport">Imprimir Reporte</a>
			</th>
			<th>Id de Profesor</th>
			<th>Nombre</th>
			<th>Fecha de Registro</th>
			<th>Clave de Profesor</th>
			
		</tr>
		<c:forEach var="profesor" items="${profesores}">
			<tr>
				<td>
					<form action="ProfesorController">
						<input type="hidden" name="id_profesor" value="${profesor.id_profesor}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${profesor.id_profesor}</td>
			<td>${profesor.nombre}</td>
			<td>${profesor.fecha_registro}</td>
			<td>${profesor.cve_prof}</td>
			
			</tr>
		</c:forEach>
	</table>

</body>
</html>