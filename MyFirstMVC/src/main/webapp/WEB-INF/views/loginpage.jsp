<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg1}
<form action="validate" method="post">
Username: <input type="text" name="uname" id="uname"><br><br>
password: <input type="text" name="password" id="password"><br><br>
<button type="submit" name="Login" id="btn" value="login">Login</button>
</form>
</body>
</html>