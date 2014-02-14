<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ACORS</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta   http-equiv= 'refresh '   content= '0;url=error_p.jsp '>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
	html {background: url('') fixed no-repeat; margin:0 auto; padding:0 auto;}
	body {margin:0 auto; padding:0 auto; width:700px; color:#303030; font-family:Arial; text-align:center;}
	a {color:#2E64FE; text-decoration:none;} a:hover {color:#2E64FE; text-decoration:underline;}
	h1 {font-size:4em; color:#0080FF;}
	h2 {font-size:2em;}
	h3 {font-size:1.5em;}
	img {border:0;}
	.footer {color:#999999; font-size:10px; margin:10px auto; text-align:right; width:600px;}
</style>
  </head>
  
  <body>
    <jsp:include page="header.inc"/>
    
	<img src="img/indeximg.jpg" />
	<h2>You buy 'em, you wear 'em!</h2>
	
	<!-- if you haven't login yet, you can do it or register, otherwise, you just allowed to logout -->
	<c:if test="${(not empty sessionScope.username)}">
		<h3>Wanna logout?&nbsp;${sessionScope.username } <a href="servlet/LogoutServlet">Logout</a>!</h3><br/>
		<h1><b><font color = "green" font="Arial"> <a href = "servlet/ListServlet">Go!</a></font></b></h1>
	</c:if>
	<c:if test="${(empty sessionScope.username)}">
		<h3>Wanna order apparel? <a href="login.jsp">Login</a>! <a href = "adminLogin.jsp">admin?</a></h3>
		<h3>If not a user, <a href="register.jsp">sign-up to register now</a>!</h3>
	</c:if>
	<jsp:include page="footer.inc"/>

  </body>
</html>
