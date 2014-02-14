<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>Admin Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta   http-equiv= 'refresh '   content= '0;url=error_p.jsp '>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


	<link rel="stylesheet" href="acors.css">    <!-- stylesheet -->
	
  </head>
  
  <body>
  	
    <jsp:include page="header.inc"/>
	<b>hello, Admin!</b><br/>
	<form name="login" method="post" action = "servlet/AdminLoginServlet">
		<table>
			<tr>
				<td>
					<b>Username:</b>
				</td>
				<td>
					<input value="" name="username" type="text" />
				</td>
			</tr>
			<tr>
				<td>
					<b>Password:</b>
				</td>
				<td>
					<input value="" name="password" type="password" />
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" name="login" 
					value="Login" onClick="" />
				</td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="footer.inc"/>
  </body>
</html>
