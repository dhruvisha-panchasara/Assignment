<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="save" method="post" modelAttribute="data">

First Name:<f:input path="firstname"/><br/>

Last Name:<f:input path="lastname"/><br/>

<f:hidden path="id"/>

<input type="submit" value="submit"> 

</f:form>

<a href="searchEmp">search data</a>
</body>
</html>