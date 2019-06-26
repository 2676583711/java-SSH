<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Login:</h1>

	<form action="/ssm1/userController" method="post">
		用户名：<input type="text" name="username" value="${requestScope.username }"/>  ${uError } <br/>
		密　码：<input type="password" name="password"/> ${pError} <br/>
		<input type="submit" value="submit"/>
		<a href="/ssm1/a.jsp"><input type="button" value="Register"/></a>

	</form>


</body>
</html>