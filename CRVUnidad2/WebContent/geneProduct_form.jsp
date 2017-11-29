<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Form</title>
</head>
<body>
<form action="GeneProductController">
		<label>Symbol:</label><br />
		<input type="text" name="symbol" value="${product.symbol}" /><br />
		<label>Dbxref ID:</label><br />
		<input type="number" name="dbxref" value="${product.dbxref}" /><br />
		<label>Species ID:</label><br />
		<input type="number" name="species" value="${product.species }" /><br />
		<label>Type ID:</label><br />
		<input type="number" name="type" value="${product.type }" /><br />
		<label>Full name:</label><br />
		<input type="text" name="name" value="${product.name }" /><br />
		<input type="submit" name="btn_save" value="save" />	
	</form>
</body>
</html>