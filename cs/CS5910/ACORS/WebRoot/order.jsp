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
    
    <title>order</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta   http-equiv= 'refresh '   content= '0;url=error_p.jsp '>
	<link rel="stylesheet" href="acors.css">
	<c:if test="${empty sessionScope.username }">
		<c:redirect url = "login.jsp"></c:redirect>
	</c:if>

  </head>
  
  <body>
    <jsp:include page="header.inc"/>
	<p>
		<b>FIRST STEP:</b> Select what you want to buy!<br/>
		<font color="red">*Note: The images below do not reflect what you buy.</font>
		<c:if test="${not empty sessionScope.username}">
			<font color = "green">Hello,</font> 
			<font color = "pink"> ${sessionScope.username }</font>
		</c:if>
		<jsp:include page="controlPane.inc"/>
	</p>

	<form name = "order" action=" servlet/OrderServlet">
		<table  border ="1">
			<tr>
				<th>
					<font color = "pink" size = "2">view </font>
				</th>
				<th>
					<font color = "pink" size = "2">product name </font>
				</th>
				<th>
					<font color = "pink" size = "2">brand </font>
				</th>
				<th>
					<font color = "pink" size = "2">size</font>
				</th>
				<th>
					<font color = "pink" size = "2">category</font>
				</th>
				<th>
					<font color = "pink" size = "2">price</font>
				</th>
				<th>
					<font color = "pink" size = "2">gender </font>
				</th>
				<th>
					<font color = "pink" size = "2">remain </font>
				</th>
				<th>
					<font color = "pink" size = "2">cart </font>
				</th>
			</tr>
			<c:forEach var = "tmp" items = "${requestScope.allProduct }">
				<tr>
					<td>
						<img alt="No img" src="${tmp.picurl}" height = "70" width = "70"/>
					</td>
					<td>
						${tmp.productname }
					</td>
					<td>
						${tmp.brand }
					</td>
					<td>
						${tmp.size }
					</td>
					<td>
						${tmp.category }
					</td>
					<td>
						${tmp.price }
					</td>
					<td>
						${tmp.gender }
					</td>
					<td>
						${tmp.remainder }
					</td>
					<td>
						<a href = "servlet/OrderServlet?pid=${ tmp.pid}">add into cart</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
		<h3>
		Now you have pick
		<c:if test="${empty sessionScope.SESSION_CART }"> 
			0
		</c:if>
		${sessionScope.SESSION_CART.itemNumber }
		clothes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href = "servlet/CartServlet">Go to my cart</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${not empty sessionScope.SESSION_CART}"><a href = "servlet/CheckOutServlet?method=index">Check out</a></c:if>
		</h3>
	
	
	<jsp:include page="footer.inc"/>
  </body>
</html>
