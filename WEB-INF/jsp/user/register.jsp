<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="css/main.css" rel="stylesheet" type="text/css" />

<head></head>

<form:form method="post" name="userController" action="user.htm?method=registerUser">



<table>
	<tr>
		<td>* Valid Email:</td>
		<td><input class="css" dir="ltr" name="email" /><form:errors path="email"/></td>
	</tr>
	<tr>
		<td>* Password:</td>
		<td><input class="css" dir="ltr" name="password" /><form:errors path="password"/></td>
	</tr>
</table>
Shipping Address:
<table>

	<tr>
		<td>* First Name</td>
		<td><input name="firstname"></input><form:errors path="firstname"/></td>
	</tr>
	<tr>
		<td>* Last Name</td>
		<td><input name="lastname" ></input><form:errors path="lastname"/></td>
	</tr>

	<tr>
		<td>* Address Line 1:</td>
		<td><input name="addressLine1" ></input><form:errors path="addressLine1"/></td>
	</tr>
	<tr>
		<td>Address Line 2:</td>
		<td><input name="addressLine2"></input></td>
	</tr>

	<tr>
		<td>* City</td>
		<td><input name="city" ></input><form:errors path="city"/></td>
	</tr>
	<tr>
		<td>* State</td>
		<td><input name="state"></input><form:errors path="state"/></td>
	</tr>
	<tr>
		<td>* PostCode</td>
		<td><input name="postCode"></input><form:errors path="postCode"/></td>
	</tr>
	<tr>
		<td>* Country</td>
		<td><%@ include file="../country.jsp" %></td>
	</tr>
	<tr>
		<td><input name="submit" type="submit" class="btn" value="Send" /></td>
	</tr>
</table>

</form:form>

* field mandatory