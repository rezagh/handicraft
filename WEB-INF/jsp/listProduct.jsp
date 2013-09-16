<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<form:form action="cart.htm?method=addToCart" name="cartForm">

<img class="productimage" alt="" src="photo.htm?method=getImage&imageId=${product.imageRef}"><br/>


Name: <c:out value="${product.name}"/><br/>
Price: USD <c:out value="${product.price}"/><br/>
Weight: <c:out value="${product.weight}"/> <c:out value="${product.weightUnit}"/><br/>
Quantity: <c:out value="${product.quantity}"/> Available<br/>
Description: <c:out value="${product.description}"/><br/><br/>

				<!-- even if the user is logged it is good to have this -->
				<%@ include file="postage.jsp" %>



<br/>
	<a href="cart.htm?method=addToCart">AddToCart</a><br/>
	<a href="cart.htm?method=showCart">See Shopping Cart</a><br/>
	
	<!-- TODO send the product code, etc  -->
	<a href="inquiry.htm?method=listInquiryPage">Ask a question about this item?</a><br/>

</form:form>






	

