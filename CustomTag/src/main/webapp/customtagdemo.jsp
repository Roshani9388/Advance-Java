<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="mytag" uri="/calculate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String num1="20";
String num2="30";
%>
<h1>Welcome to custon tags</h1>
<mytag:mycalculate num1="<%=num1%>" num2="<%=num2 %>"></mytag:mycalculate>
<mytag:myhello fname="roshani" lname="patil"></mytag:myhello>
</body>
</html>