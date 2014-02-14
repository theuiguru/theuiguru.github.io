<%-- 
    Document   : index
    Created on : Apr 30, 2012, 8:07:56 PM
    Author     : cthoma29
--%>
<jsp:useBean id="bean" class="JavaBean.PizzaOrderBean" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html><html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CT's Pizzeria</title>
</head><body bgcolor="#FDF5E6" background="pizzalogo.png" style="background-repeat:no-repeat; background-position: right;">
<h1 style="color:#FF6600">CT's Pizzeria</h1>
<p><b>Enter in the amount of pizzas you would like to order for each topping:</b></p>
<form method="POST" action="/FinalProject/PizzaServlet">
    <p>Regular ($8): <input type="text" name="regular" maxlength="2" size="2" /></p>
    <p>Supreme ($10): <input type="text" name="supreme" maxlength="2" size="2" /></p>
    <p>Vegetarian ($10): <input type="text" name="vege" maxlength="2" size="2" /></p>
<p><input type="submit" value="Put in Shopping Cart" name="cart" />
   <input type="submit" value="Check Out" name="cart" /></p>
</form></body></html>