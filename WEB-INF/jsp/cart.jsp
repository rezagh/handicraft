<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script src="js/jquery-1.3.2.js" type="text/javascript"></script>
<script type='text/javascript' src='dwr/interface/DwrFrontController.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<%@ page import="com.handicraft.vo.CartVO" %>
<%@ page import="com.handicraft.util.Codes" %>
<%@ page import="java.util.List" %>
<%@ page import="com.handicraft.model.type.CountryEnum" %>


<script>
</script>


<form:form method="post" name="theform" action="cart.htm?method=updateCart">

		Your Country:    
		<%@ include file="country.jsp" %>
		 (Change this to fix the postage prices)<br/>

<br/>

	<table border="1">
		<tr>
			<td>Name</td>	
			<td>Price</td>
			<td>Quantity</td>
			<td>Remove</td>
		</tr>
		<c:forEach var="p" items="${cart.cartItems}">
			<tr>
				<td><c:out value="${p.product.name}"/></td>
				<td><c:out value="${p.product.price}"/></td>
				<td><input name="${p.product.code}_new_quantity" size="4" value="<c:out value="${p.orderQuantity}"/>"/></td>
				<td><a href="cart.htm?method=removeFromCart&productCode=${p.product.code}">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Update Table"/><br/><br/>
	Postage = ${cart.orderPostage}<br/>
	Total = ${cart.orderTotalPrice}<br/>
	
	
	
</form:form>

<br/>
		

	<a href="cart.htm?method=showAddressConfirmation">Checkout</a> |
	<a href="front.htm">Continue Shopping</a> | 
	<a href="cart.htm?method=clearCart">Clear Cart</a> | 
	 
	
	
	
		