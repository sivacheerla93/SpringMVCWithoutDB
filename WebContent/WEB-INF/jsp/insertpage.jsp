<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Employee</title>
</head>
<body>
	<form:form action="save.html" method="post">
Enter EmployeeID: <form:input path="id" />
Enter EmployeeName: <form:input path="name" />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>