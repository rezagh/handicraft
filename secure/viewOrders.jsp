<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<table border="1">
	<tr>
		<td>Order No.</td>
		<td>Date</td>
		<td>Order Status</td>
		<td>Payment Status</td>
		<td>Change Status</td>
		<td>Operator</td>
	</tr>

		<c:forEach var="o" items="${orders}">
			<tr>	
				<td><c:out value="${o.number}"/></td>
				<td><c:out value="${o.date}"/></td>
				<td><c:out value="${o.status}"/></td>
				<td><c:out value="${o.paymentStatus}"/></td>
				<td><a href="orderManager.htm?method=showChangeOrderPage&orderNumber=${o.number}">Change</a></td>
				<td><c:out value="${o.operator.firstname}"/></td>
			</tr>
		</c:forEach>

</table>

<a href="orderManager.htm?method=showAllOrders">Show All Orders</a> | 
<a href="orderManager.htm?method=showActiveOrders">View Active Orders</a> |
<a href="productManager.htm?method=showProductManager">Back</a>