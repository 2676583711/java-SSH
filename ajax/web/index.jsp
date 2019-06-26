<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 27/05/18
  Time: 下午 06:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用ajax校验</title>
    <script type="text/javascript" src="WEB-INF/js/verify.js"></script>
</head>
<body>

<h1>$END$</h1>

<h2>普通校验</h2>

<form action="/AServlet">
    <input type="text" name="name"/> <br/>
    <input type="submit" value="提交"/>
</form>

<hr/>
<h1>ajax校验</h1>
<input type="text" id="username"/> <span id="span"></span><br/>
<input type="button" value="submit" onclick="verify()"/>


</body>
</html>
