<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCreditCard.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="acors.css">
  </head>
  
  <body>
    <%
    	if(request.getSession(true).getAttribute("cid") == null 
			|| "".equals(request.getSession(true).getAttribute("cid"))){
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  		}
     %>
     
    <script type="text/javascript" src="calendar.js"></script>
    <jsp:include page="header.inc"/>
	<jsp:include page = "controlPane.inc"/>
    <form action="servlet/AddCreditCardServlet" method = "post">
    <table border = "1" align = center width = "50%">
    	<tr>
    		<th colspan = "2">
    			Add a Credit Card:
    		</th>
    	</tr>
    	<tr>
    		<td>
    			Card ID:
    		</td>
    		<td>
    			<input type = "text" name = "cardId"/>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			First Name:
    		</td>
    		<td>
    			<input type = "text" name = "firstName">
    		</td>
    	</tr>
     	<tr>
    		<td>
    			Last Name:
    		</td>
    		<td>
    			<input type = "text" name = "lastName">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			Cart Type:
    		</td>
    		<td>
    			<input type = "text" name = "cartType">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			Secutity Number:
    		</td>
    		<td>
    			<input type = "text" name = "secutityNum">
    		</td>
    	</tr>
    	
    	<tr>
    		<td>
    			Expiry Date:
    		</td>
    		<td>
    		<input name="expiryDate" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" 
			 readonly="readonly" />
    		</td>
    	</tr>
    	<tr>
    		<td colspan = 2>
    		<input type = submit  value = "submit"/>
    		<input type = reset value = "reset"/>
    		</td>
    	</tr>
     </table>
     
    </form>
    <jsp:include page="footer.inc"/>
  </body>
</html>
