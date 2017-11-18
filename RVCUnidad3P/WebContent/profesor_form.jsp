<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profesor Form</title>
</head>
<body>
	<form action="ProfesorController">
	
		<label>Nombre:</label><br/>
		<input type="text" name="nombre" value="${profesor.nombre}"/><br/>
		<label>Fecha de Registro:</label><br/>
		<input type="text" name="fecha_registro" value="${profesor.fecha_registro}"/><br/>
		<label>Clave de Profesor:</label><br/>
		<input type="text" name="cve_prof" value="${profesor.cve_prof}"/><br/>
		
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>