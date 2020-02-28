<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>DATA TABLE</h1><br/><br/>
<table border="1">
<tr>
<th>ID</th>
<th>FN</th>
<th>LN</th>
<th>DELETE</th>
<th>EDIT</th>
</tr>
<i:forEach items="${emplist}" var="z">
<tr>
<td>${z.id}</td>
<td>${z.firstname}</td>
<td>${z.lastname}</td>
<td><a href="delete?id=${z.id}">DELETE</a></td>
<td><a href="edit?id=${z.id}">EDIT</a></td>
</tr>

</i:forEach>

</table>


</body>
</html>