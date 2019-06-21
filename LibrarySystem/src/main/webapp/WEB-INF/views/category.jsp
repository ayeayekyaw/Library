<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@include file="/WEB-INF/views/menu.jsp"%>
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
<body>
	<h4>Please type name!</h4>
	<form:form method="post"
		action="${pageContext.request.contextPath}/create_category.htm"
		commandName="category">
		<form:hidden path="id"/>
Name: <form:input path="name" type="text" />
			<br>
Description: <form:input path="description" type="text" />
			<br>
			<input type="submit" value="Save" />
	</form:form>

</body>
</html>