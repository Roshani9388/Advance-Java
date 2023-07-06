<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addnewproduct" method="post">

Pid: <input type="text" id="pid" name="pid">
Pname: <input type="text" id="pname" name="pname">
Quantity: <input type="text" id="qty"  name="qty">
Price: <input type="text" id="price" name="price">
<button type="submit" name="btn" id="btn" value="update">Add new Product</button>
</form>
</body>
</html>