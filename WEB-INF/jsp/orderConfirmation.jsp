<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

	<table border="1">
		<tr>
			<td>Name</td>	
			<td>Price</td>
			<td>Quantity</td>
			
		</tr>
		<c:forEach var="p" items="${cart.cartItems}">
			<tr>
				<td><c:out value="${p.product.name}"/></td>
				<td><c:out value="${p.product.price}"/></td>
				<td><c:out value="${p.orderQuantity}"/></td>
				
			</tr>
		</c:forEach>
	</table>
	Postage = ${cart.orderPostage}<br/>
	Total = 	${cart.orderTotalPrice} <br/>

		
<br/>
Address:

	<table border="1">
		<tr>
			<td>
				First Name</td>
			<td><c:out value="${user.firstname}"/></td>
		</tr>
		<tr>
			<td>
				Last Name</td>
			<td><c:out value="${user.lastname}"/></td>
		</tr>
		<tr>
			<td>
				Address Line 1:</td>
			<td><c:out value="${user.addressLine1}"/></td>
		</tr>
		<tr>
			<td>Address Line 2:</td>
			<td><c:out value="${user.addressLine2}"/></td>
		</tr>
	
		<tr>
			<td>City</td>
			<td><c:out value="${user.city}"/></td>
		</tr>
		<tr>
			<td>State</td>
			<td><c:out value="${user.state}"/></td>
		</tr>
		<tr>
			<td>PostCode</td>
			<td><c:out value="${user.postCode}"/></td>
		</tr>

		<tr>
			<td>Country</td>
			<td><c:out value="${user.country}"/></td>
		</tr>
	</table>


	<a href="order.htm?method=submitPaypalOrder">Pay in PayPal</a> <br/><br/>
	<!-- leave this for now. it is difficult
	<a href="order.htm?method=submitAndPayLater">Submit and pay later (Paypal or Bank Transfer)</a>
	  -->

<!-- no extra link in needed here. user already had a chance to do the changes. -->	



