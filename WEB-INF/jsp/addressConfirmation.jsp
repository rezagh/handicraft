<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<script>
	function validate(){
		if(document.getElementById('orderPostCode').value== '' || 
				document.getElementById('orderState').value== '' ||
				document.getElementById('orderName').value== '' ||
				document.getElementById('orderAddress').value== '' ||
				document.getElementById('orderCity').value== '' ||
				document.getElementById('countrySelected').value== '--') {
			alert("Complete the Address First.") ;
			document.getElementById('postalRate').value= '';
		}
		document.theform.submit();
	}

</script>

	<table border="1">
		<tr>
			<td>Name</td>	
			<td>Price</td>
			<td>Quantity</td>
			
		</tr>
		<c:forEach var="ci" items="${cart.cartItems}">
			<tr>
				<td><c:out value="${ci.product.name}"/></td>
				<td><c:out value="${ci.product.price}"/></td>
				<td><c:out value="${ci.orderQuantity}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	Postage = ${cart.orderPostage}<br/>
	Total = ${cart.orderTotalPrice}
	

<br/>		
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
	<br/>
	<security:authorize ifAnyGranted="ROLE_USER">
		<a href="order.htm?method=showOrderConfirmation">Buy Now</a> (You will confirm in the next page) 
		<br/><br/>
		<a href="user.htm?method=showUserAccount">Change Address</a> |
	</security:authorize>
	
	<security:authorize ifNotGranted="ROLE_USER">
		<a href="user.htm?method=showRegisterPage">To buy you need to register</a> |
	</security:authorize>
	

	<a href="cart.htm?method=showCart">Change Order</a> | <a href="front.htm">Continue Shopping</a><br/>
	



