<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Employee Details</h1>

<form action="update" method="post">
ID:<input type="text" name="id" value="${employee.id}" readonly="readonly"><br><br>
Name:<input type="text" name="name" value="${employee.name}"><br><br>
Sallary:<input type="text" name="sallary" value="${employee.sallary}"><br><br>
<input type="submit" value="Update"><br><br>
</form>

</body>
</html>