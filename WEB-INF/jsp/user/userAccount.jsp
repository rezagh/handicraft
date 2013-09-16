<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head></head>

<form:form method="post" name="userController" action="user.htm?method=editUser">



<table>
	<tr>
		<td>Email:</td>
		<td><c:out value="${user.email}"/></td>
	</tr>


		<tr>
			<td>First Name</td>
			<td><input name="firstname" value="<c:out value="${user.firstname}"/>"/><form:errors path="firstname"/></td>
		</tr>

		<tr>
			<td>Last Name</td>
			<td><input name="lastname" value="<c:out value="${user.lastname}"/>"/><form:errors path="lastname"/></td>
		</tr>
		<tr>
			<td>Address Line 1:</td>
			<td><input name="addressLine1" value="<c:out value="${user.addressLine1}"/>"/><form:errors path="lastname"/></td>
		</tr>
		<tr>
			<td>Address Line 2:</td>
			<td><input name="addressLine2" value="<c:out value="${user.addressLine2}"/>"/></td>
		</tr>
	
		<tr>
			<td>City</td>
			<td><input name="city" value="<c:out value="${user.city}"/>"/><form:errors path="city"/></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input name="state" value="<c:out value="${user.state}"/>"/></td>
		</tr>
		<tr>
			<td>PostCode</td>
			<td><input name="postCode" value="<c:out value="${user.postCode}"/>"/></td>
		</tr>

		<tr>
			<td>Country</td>
			<td><%@ include file="../country.jsp" %></td>
		</tr>
	<tr>
		<td><input name="submit" type="submit" class="btn" value="Update" /></td>
	</tr>
	</table>

</form:form>

${result}

<a href="redirect.htm?pageId=changePass"/>Change Password</a> | 
<a href="order.htm?method=showOrderHistory">Order History</a> | <br/><br/> 
