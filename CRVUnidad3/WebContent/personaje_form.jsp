<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personaje Form</title>
</head>
<body>
	<form action="PersonajeController">
	
		<label>posicion Actual:</label><br/>
		<input type="text" name="posicion_actual" value="${personaje.posicion_actual}"/><br/>
		<label>Velocidad:</label><br/>
		<input type="text" name="velocidad" value="${personaje.velocidad}"/><br/>
		<label>Estado:</label><br/>
		<input type="text" name="estado" value="${personaje.estado}"/><br/>
		
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>