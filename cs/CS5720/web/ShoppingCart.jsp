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
<p><b>Shopping Cart:</b></p>
<form method="POST" action="/FinalProject/PizzaServlet">
    <p>Regular ($8): <%= bean.getRegular() %></p>
    <p>Supreme ($10): <%= bean.getSupreme() %></p>
    <p>Vegetarian ($10): <%= bean.getVege() %></p>
    <p>Total Price: $<%= bean.getTotal() %></p>
<p><input type="submit" name="cart" value="Remove Order" />
<input type="submit" name="cart" value="More Pizza" />
<input type="submit" name="cart" value="Check Out" /></p>
</form></body></html>