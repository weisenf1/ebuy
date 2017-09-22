<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>admin管理</title>
</head>
<body>
	<form action="AdminServlet" method="post" onsubmit="return check()"><!-- 没有return 页面会继续跳转 -->
		<table>
			<tr><td>用户名：</td><td><input type="text" name="username" id="username"></td></tr>
			<tr><td>密码：</td><td><input type="password" name="password" id="password"></td></tr>
		</table>
		<input type="submit" value="提交">
	</form>
	<script type="text/javascript">
		function check(){
			var username=document.getElementById("username").value;
			var password=document.getElementById("password").value;
			if(username==""){
				alert("用户名为空");
				return false;
			}
			if(password==""){
				alert("密码为空");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>