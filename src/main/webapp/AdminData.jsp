<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.weisen.ebuy2.entity.Admin" %>
<%@ page import="com.weisen.ebuy2.dao.AdminDao" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员数据</title>
</head>
<%
	List<Admin> adminList=new AdminDao().adminQuery();
	
%>
<body>
	<form action="AdminDataServlet" method="post" name="form1">
		<input type="hidden"  name="hide" id="hide">
		<input type="submit" value="增加" onclick="return confirm(this.id)" id="insert">
		<input type="submit" value="修改" onclick="return confirm(this.id)" id="update">
		<input type="submit" value="删除" onclick="return confirm(this.id)" id="delete">
	
	
	<table border="1" id="mytable">
		<thead><tr><th>用户名</th><th>密码</th><th>权限</th></tr></thead>
		<tbody>
		<% 
		for(int i=0;i<adminList.size();i++){
			Admin admin=adminList.get(i);
			admin.getUsername();
			admin.getPassword();
			admin.getPermission();
		
			%><tr><td onclick="test(this.id)" id="<%=i+1 %>"><%=admin.getUsername() %></td><td><%=admin.getPassword()%></td><td><%=admin.getPermission() %></td></tr>
		<% } %>
		</tbody>
	</table>
		<input type="text" name="username" id="username">
		<input type="text" name="password" id="password">
		<input type="text" name="permission" id="permission">
	</form>
	<script type="text/javascript">
		function test(id){
			var tableId="mytable";
			var table=document.getElementById(tableId);
			var tableCol=table.rows[id].cells.length;//id所属行的列数
			//alert(tableCol);
			var element=new Array();
			for (var i = 0; i < tableCol; i++) {
				element[i]=table.rows[id].cells[i].innerHTML;
			}
			//var element=table.rows[id].cells[0].innerHTML;
			//var element="123";
			//alert(element);
			//return element;
			//document.form1.update.value=element;
			document.getElementById("username").value=element[0];
			document.getElementById("password").value=element[1];
			document.getElementById("permission").value=element[2];
			//alert(element[0]);
		}
		function confirm(id){
			alert(id);
			if(document.getElementById("username").value==""){
				alert("请选择一行数据")
				return false;
			}
			
			//document.form1.hide.value=id
			document.getElementById("hide").value=id;
			alert(document.getElementById("hide").value);
				
			
			
			return true;
		}
		
	</script>
</body>
</html>