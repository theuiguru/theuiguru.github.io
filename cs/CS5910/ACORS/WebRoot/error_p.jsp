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
    
    <title>Eooro page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!--  if exist param.errorMessage in URL, print it; otherwise, print ERROR -->
  	<c:if test="${not empty params.errorMessage }">
  		<font size = 4>${params.errorMessage }</font>
  	</c:if>
    <c:if test = "${empty params.errorMessage }">
        <font size = 4>ERROR </font>
    </c:if>
    <!--  if exist param.forward  in URL, forward to the URL, otherwise , go to index.jsp-->
    <c:if test="${not empty params.forward }">
  	  <jsp:forward page="${ params.forward}.jsp"/>
    </c:if>
	<c:if test="${empty params.forward }">
		<jsp:forward page="index.jsp"></jsp:forward>
	</c:if>	
  </body>
</html>
