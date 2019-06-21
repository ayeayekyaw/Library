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
<h4>Please type your name!</h4>
<form:form method="post" action="${pageContext.request.contextPath}/create_student.htm" commandName="student">
<form:hidden path="id"/>
Name: <form:input path="name" type="text"/><br>
RollNo: <form:input path="rollNo" type="text" /><br>
<input type="submit" value="Login" />
</form:form>
</body>
</html>