<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <!--  =====================important========================= -->
     <c:url var="addAction" value="/employee/save" ></c:url>
     
    <!--  above tag is import 
     because if you d'not write form tag like this 
     you will get error in either save function or update function -->
     
	<form:form action="${addAction}" method="get" commandName="employee">
	
	 <!--  =====================important========================= -->
	 
		<table>
		    <tr>
				<td><spring:message code="employee.id" /></td>
				<td><form:input path="id"  value="${employee.id}" readonly="true"/></td>
			</tr>
			<tr>
				<td><spring:message code="employee.code" /></td>
				<td><form:input path="empCode"  value="${employee.empCode}" /></td>
			</tr>
			<tr>
				<td><spring:message code="employee.name" /></td>
				<td><form:input path="empName" value="${employee.empName}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>				
			</tr>
		</table>
	</form:form>
</body>
</html>