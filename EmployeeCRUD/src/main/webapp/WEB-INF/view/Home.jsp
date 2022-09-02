<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Home Page</h1>
<a href="add">Add Employees</a>
<table border="1">
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Sallary</th>
<th>Action</th>
</tr>
</thead>
<br>
<br>
<tbody>


<c:forEach var="e" items="${employeeList}">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.sallary}</td>
<td><a href="delete?eid=${e.id}">Delete</a>
<a href="toupdate?eid=${e.id}">Update</a>
</td>
</tr>


</c:forEach>
</tbody>
</table>
</body>
</html>