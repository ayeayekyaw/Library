<%@include file="/WEB-INF/views/menu.jsp" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Book Information</h3>
	<table>
		<thead>
			<tr>
				<th>No:</th>
				<th>Name</th>
				<th>Author</th>
				<th>ISBN</th>
				<th>Delete</th>
				<th>Update</th>
				</tr>
	</thead>
	<tbody>
	
	<c:forEach var="emp" items="${bookList }" varStatus="index">
		<tr>
		<td>${index.count }</td>
		<td>${emp.name }</td>
		<td>${emp.author }</td>
		<td>${emp.isbn }</td>
		<td><a href="<c:url value='/deleteBook/${emp.id}'/>">Delete</a>
		<td><a href="<c:url value='/updateBook/${emp.id}'/>">Update</a>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>