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
<p><b>Order Information:</b></p>

<p>Regular ($8): <%= bean.getRegular() %></p>
<p>Supreme ($10): <%= bean.getSupreme() %></p>
<p>Vegetarian ($10): <%= bean.getVege() %></p>
<p>Total Price: $<%= bean.getTotal() %></p>

<p>Today is <SCRIPT LANGUAGE = "JavaScript"><!--
// Array of day names
var dayNames = new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
var monthNames = new Array("January","February","March","April","May","June","July",
                           "August","September","October","November","December");
var dt = new Date();
var y  = dt.getYear();
// Y2K compliant
if (y < 1000) y +=1900;
document.write(dayNames[dt.getDay()] + ", " + monthNames[dt.getMonth()] + " " + dt.getDate() + ", " + y);
// --></SCRIPT></p>

<p><i>Thank You For Ordering from CT's Pizzeria!</i></p>
</body></html>