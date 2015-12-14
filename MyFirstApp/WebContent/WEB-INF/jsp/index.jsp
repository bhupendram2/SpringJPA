<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is my First web Application</h1>
<h2><a href="hello">click here to go welcome page</a></h2>
<a href="<c:url value='/employee/create'/>">Add new employee</a>
<spring:message code="label.title" />
<table id="listOfEmployees" border="1">
    <tr>
        <td>Employee Code</td>
        <td>Employee Name</td>
        <td>Action</td>
      </tr>
    <c:forEach items="${emp}" var="employee">   
      <tr>
        <td>${employee.empCode}</td>
        <td>${employee.empName}</td>
        <td><a href="<c:url value='/employee/edit/${employee.id}'/>">Edit</a>
            <a href="<c:url value='/employee/delete/${employee.id}'/>">Delete</a>
         </td>
      </tr>
    </c:forEach>
    </table>
</body>
</html>