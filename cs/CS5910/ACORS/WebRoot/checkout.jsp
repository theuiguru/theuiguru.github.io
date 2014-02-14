<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkout.jsp' starting page</title>
    
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
 	<script type="text/javascript" src="calendar.js"></script>
    <jsp:include page="header.inc"/>
    <jsp:include page = "controlPane.inc"/>
    <h1 align = center>
    	<font size = "5">
    		Your order list:
    	</font>
    </h1>
    <form >
    <table border = "1" align = "center" width = "70%">
    	<tr>
    		<th>
    			product
    		</th>
    		<th>
    			unit cost
    		</th>
    		<th>
    			number
    		</th>
    		<th>
    			total
    		</th>
    	</tr>
    	<c:forEach var = "item" items = "${sessionScope.SESSION_CART.items}">
    		<tr align = "center">
    			<td>
    				${item.value.product.productname }
    			</td>
    			<td>
    				${item.value.product.price }
    			</td>
    			<td>
    				${item.value.quantity}
    			</td>
    			<td>
    				${item.value.price }
    			</td>
    		</tr>
    	</c:forEach>
    	<tr>
    		<td colspan = 5>
    			<font size = "3" color ="blown">sum:&nbsp; </font>
    			${sessionScope.SESSION_CART.cost }
    		</td>
    	</tr>
   	</table>
    </form>
    
    <c:if test="${empty sessionScope.creditCards }">
    	<center>you have no credit card yet! <a href = "addCreditCard.jsp">add a Credit Card</a><br></center>
    	<hr>
    </c:if>
    <c:if test="${not empty sessionScope.creditCards }">
    	<center>
    	    <h1>
    		<font size = "5">
    		Your Credit Card list:
    		</font>
    		</h1>
    		<form action="servlet/CheckOutServlet?method=submit" method = "post">
		    <table border = "1" align = center width = "50%">
		    	<tr>
		    		<th colspan = "2">
		    			Select a Credit Card to pay the bill:
		    		</th>
		    	</tr>
		    	<tr>
		    		<td>Credit Card</td>
		    		<td>
		    			<select name = "payCardId">
					    	<c:forEach var = "item" items = "${sessionScope.creditCards}">
					    		<option value = "${item.cardId}">
					    			${item.cardId } owner:${item.fName } cardType:${item.cardType} 
					    		</option>
				    		</c:forEach>
		    			</select>
		    		</td>
		    	</tr>
		    	<tr>
		    		<td colspan = 2>
		    		<input type = submit  value = "submit"/>
		    		&nbsp;&nbsp;&nbsp;<a href = "addCreditCard.jsp">add a Credit Card</a>
		    		</td>
		    	</tr>
		    </table>
		    </form>
    	</center>
    	<hr>
    </c:if>
    
    <jsp:include page="footer.inc"/>
  </body>
</html>
