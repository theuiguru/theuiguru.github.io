<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" href="acors.css">


	
	<script type="text/javascript" language="javascript">
	//this function don't work at present
	function registerCheck() {
		var firstName = register.firstName.value;//document.getElementByName("firstName").value;
		var fName = document.getElementById("fName");
		//var valid = true;
		if(firstName==null || firstName.equals("")) {
			fName.style.color = "red";
			fName.style.fontWeight = "bold";
			fName.innerHTML = "*Invalid Data";
			valid = false;
			alert("Invalid data!");
			return false;
		}
		alert("dfda!");
		register.submit();
	}
	</script>
  </head>
  
  <body>
  <script type="text/javascript" src="calendar.js"></script>
    <jsp:include page="header.inc"/>
<b>Sign up for an ACORS account today!</b><br/>
<form name="register" method="post" action = "servlet/RegisterServlet"><table>
<tr><td><b>First Name</b></td>
<td><input maxlength="100" type="text" name="firstName" /><label id="fName"></label></td></tr>
<tr><td><b>Last Name</b></td>
<td><input maxlength="100" type="text" name="lastName" /></td></tr>
<tr><td><b>Username</b></td>
<td><input maxlength="100" name="username" type="text" /></td></tr>
<tr><td><b>Password</b></td>
<td><input maxlength="100" name="password" type="password" /></td></tr>
<tr><td><b>E-mail</b></td>
<td><input maxlength="100" type="text" name="email" /></td></tr>
<tr><td><b>Phone</b></td>
<td><input maxlength="100" type="text" name="phone" /></td></tr>
<tr>
	<td>
		<b>Birthday</b>
	</td>
	<td>
			<input name="birthday" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" 
			 readonly="readonly" />
	</td>
</tr>
<tr><td><b>Gender</b></td>
<td><select name="gender"><option value="female">Female</option><option value="male">Male</option><option value="noComment">I'd rather not say</option></select></td></tr>
<tr><td><b>Street</b></td><td><input type="text" maxlength="100" name="street" /></td></tr>
<tr><td><b>City</b></td><td><input type="text" maxlength="100" name="city" /></td></tr>
<tr><td><b>State</b></td><td><select name="state">
	<option value="AL">Alabama</option>
	<option value="AK">Alaska</option>
	<option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option>
	<option value="CA">California</option>
	<option value="CO">Colorado</option>
	<option value="CT">Connecticut</option>
	<option value="DE">Delaware</option>
	<option value="DC">District of Columbia</option>
	<option value="FL">Florida</option>
	<option value="GA">Georgia</option>
	<option value="HI">Hawaii</option>
	<option value="ID">Idaho</option>
	<option value="IL">Illinois</option>
	<option value="IN">Indiana</option>
	<option value="IA">Iowa</option>
	<option value="KS">Kansas</option>
	<option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option>
	<option value="ME">Maine</option>
	<option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option>
	<option value="MI">Michigan</option>
	<option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option>
	<option value="MO">Missouri</option>
	<option value="MT">Montana</option>
	<option value="NE">Nebraska</option>
	<option value="NV">Nevada</option>
	<option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option>
	<option value="NM">New Mexico</option>
	<option value="NY">New York</option>
	<option value="NC">North Carolina</option>
	<option value="ND">North Dakota</option>
	<option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option>
	<option value="OR">Oregon</option>
	<option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option>
	<option value="SC">South Carolina</option>
	<option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option>
	<option value="TX">Texas</option>
	<option value="UT">Utah</option>
	<option value="VT">Vermont</option>
	<option value="VA">Virginia</option>
	<option value="WA">Washington</option>
	<option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option>
	<option value="WY">Wyoming</option>
</select></td></tr>
<tr><td><b>Zip Code</b></td><td><input type="text" maxlength="100" name="zip" /></td></tr>
<tr><td align="center" colspan="2"><input type="submit" name="register" value="Sign up" class = "button" onclick="registerCheck()" /> <input type="reset" name="reset" value="Clear" /></td></tr></table></form>

	<jsp:include page="footer.inc"></jsp:include>
  </body>
</html>
