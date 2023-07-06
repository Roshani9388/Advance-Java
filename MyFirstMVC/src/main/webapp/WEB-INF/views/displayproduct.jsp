<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
	<th>PID</th>
	<th>PNAME</th>
	<th>QUANTITY</th>
	<th>PRICE</th>
	<th>Action</th>
</tr>
<c:forEach var="prod" items="${plist}">
<tr>
	<td>${prod.pid}</td>
	<td>${prod.pname}</td>
	<td>${prod.qty}</td>
	<td>${prod.price}</td>
	
	<td>
	<a href="edit/${prod.pid}">Edit</a>/<a href="delete/${prod.pid}">Delete</a></td>
</tr>
</c:forEach>
</table>

<br>
<br>
<a href="addproduct">Add Product</button>
<a href="logout">LogOut</a>
</body>
</html>