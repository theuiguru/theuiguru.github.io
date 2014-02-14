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
    
    <title>My cart</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="acors.css">
	
	<script type="text/javascript">
		function clearCart(){
			cartForm.action = "servlet/CartServlet?method=clear";
			cartForm.submit();
		}
		function deleteCartItems(){
			cartForm.action = "servlet/CartServlet?method=deleteItems";
			cartForm.submit();
		}
		function modifyNumber(){
			cartForm.action="servlet/CartServlet?method=modify";
			cartForm.submit();
		}
		function list(){
			cartForm.action = "servlet/ListServlet";
			cartForm.submit();
		}
		function checkOut(){
			cartForm.action = "servlet/CheckOutServlet?method=index";
			cartForm.submit();
		}
	</script>
  </head>
  
  <body>
  	<% 
  		if(session.getAttribute("cid") == null || "".equals(session.getAttribute("cid"))){
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  		}
  	 %>
  	<jsp:include page="header.inc"/>
  	<jsp:include page = "controlPane.inc"/>
    <h1 align = "center">Shopping Cart</h1>
    <form name = "cartForm" action = "servlet/CartServlet" method = "post">
    <table border = "1" align = "center" width = "70%">
    	<tr>
    		<th>
    			select
    		</th>
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
    				<input type ="checkbox" value = "${item.key }" name = "itemCheck"/>
    			</td>
    			<td>
    				${item.value.product.productname }
    			</td>
    			<td>
    				${item.value.product.price }
    			</td>
    			<td>
    				<input maxLength = 10 size = 10 value = ${item.value.quantity } name = "quantity${item.key}">
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
    <br>
    <table align = "center">
    	<tr>
    		<td>
    			<input type = "button" value = "change number" onclick = "modifyNumber()" name = modify>
    		</td>
    		<td>
    			<input type = button value = "delete selected items" onclick = "deleteCartItems()" name = "delete"> 
    		</td>
    		<td>
    			<input type = button value = "clear my cart" onclick = "clearCart()" name = "clear">
    		</td>
    		<td>
    			<input type = button value = "pick more goods" 
    			onclick = "list()" name = pickmore>
    		</td>
    		<td>
    			<input type = button value = "check out" 
    				onclick = "checkOut()">
    		</td>
    	</tr>
    </table>
    <jsp:include page="footer.inc"/>
  </body>
</html>
