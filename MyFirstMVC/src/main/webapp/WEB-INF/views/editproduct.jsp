<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/MyFirstMVC/product/updateproduct" method="post">

Pid: <input type="text" id="pid" value="${prod.pid}" name="pid" readOnly>
Pname: <input type="text" id="pname" value="${prod.pname}" name="pname">
Quantity: <input type="text" id="qty" value="${prod.qty}" name="qty">
Price: <input type="text" id="price" value="${prod.price}" name="price">
<button type="submit" name="btn" id="btn" value="update">Update Product</button>
</form>
</body>
</html>