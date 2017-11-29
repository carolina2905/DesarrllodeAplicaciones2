
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product list</title>
</head>
<body>
<table border="1">
		<tr>
			<th>
			  <form action="GeneProductController">
			  		<input type="submit" name="btn_new"
			  		value="New "/>
			  </form>
			</th>
			<td>Id</td>
			<td>Symbol</td>
			<td>Dbxref ID</td>
			<td>Species ID</td>
			<td>Type ID</td>
			<td>Full name</td>
		</tr>
		 <d:forEach var="product" items="${products}">
		 	 <tr>
		 	 	<td>
		 	 		<form action="GeneProductController">
		 	 			<input type="hidden" name="id" value="${product.id}">
		 	 			<input type="submit" name="btn_edit" value="Edit"/>
		 	 			 <input type="submit" name="btn_delete" value="Delete"/>
		 	 		</form>
		 	 	</td>
		 	 	<td>${product.id}</td>
		 	 	<td>${product.symbol}</td>
		 	 	<td>${product.dbxref}</td>
		 		<td>${product.species}</td>
		 	 	<td>${product.type}</td>
		 	 	<td>${product.name}</td>
		 	 </tr>	
		 </d:forEach>
	</table>
</body>
</html>