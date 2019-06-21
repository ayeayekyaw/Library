<%@include file="/WEB-INF/views/menu.jsp" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tr>
		<th>No</th>
		<th>RentDate</th>
		<th>Quantity</th>
		<th>Delete</th>
		<th>Update</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="emp" items="${bookrentList }" varStatus="row">
		<tr>
		<td>${row.count }</td>
		<td>${emp.rentdate}</td>
		<td>${emp.qty}</td>
		
		<td><a href="<c:url value='/deleteBookRent/${emp.id}'/>">Delete</a></td>
		<td><a href="<c:url value='/updateBookRent/${emp.id}'/>">Update</a></td>
		
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>