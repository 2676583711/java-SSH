<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



<script src="jquery-3.3.1.min.js"></script>
<script src="WEB-INF/js/authentication.js"></script>

</head>


<body>
	<h1>this is a jsp page!!!</h1>
	<h2>Register</h2>


   	<!-- 此处的action访问路径必须从(/+项目+访问目标)名开始 -->
	<form action="/ssm1/httpHandler" method="post">
		用户名：<input type="text" id="username"  name="username" onblur="v1()"/> <div id="uid"></div> <br/>
		密　码：<input type="password"  id="password" name="password" onblur="v3()"/> <div id="pid"></div> <br/>
		<input type="submit" value="submit">
		<a href="/ssm1/b.jsp"><input type="button" value="Login"/></a>

	</form>
	
	<script type="text/javascript">
	  function v1(){
		  $.get("http://localhost:8080/ssm1/httpHandler",{username:$("#username").val()},function(result){
			  $("#uid").html(result)
		  });
	  }
	  
	  function v3(){
		  $.ajax([url:"/ssm1/httpHandler",type:"get",data:'$("#password").val()',success:function(result){
			  $("#password").html(result);
		  }]});
	  }
	</script>
	
	
</body>
</html>