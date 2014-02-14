		<c:if test="${not empty sessionScope.username}">
			<font color = "green"><a href = "servlet/LogoutServlet">Logout</a></font>
			<font color = "pink"><a href = "servlet/HistoryOrdersServlet">History Orders</a></font>
			<font color = "green"><a href = "servlet/ListServlet">shopping</a></font>
		</c:if>