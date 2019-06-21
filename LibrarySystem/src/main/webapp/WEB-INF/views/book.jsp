<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@include file="/WEB-INF/views/menu.jsp" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Please Enter Book Name</h3>
<form:form method="post" action="${pageContext.request.contextPath}/postInfo.htm" 
	commandName="book">
	<form:hidden path="id" />
	Name: <form:input path="name" type="text"/><br>
	Author: <form:input path="author" type="text" /><br>
	ISBN:<form:input path="isbn" type="text"/><br>
	CategoryID:<form:select path="categoryId" type="text">
		<form:options items="${category}" itemValue="id" itemLabel="name"/> 
	</form:select>
	<br>
<input type="submit" value="Save" />


</form:form>
</body>
</html>