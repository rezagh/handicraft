<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<table border="1">
	<tr>
		<td>Order No.</td>
		<td>Date</td>
		<td>Order Status</td>
		<td>Payment Status</td>
		<td>Amount</td>
		<td>Mark order as Received</td>
		<td>View Order</td>
	</tr>
		<c:forEach var="o" items="${orders}">
			<tr>	
				<td><c:out value="${o.number}"/></td>
				<td><c:out value="${o.simpleDate}"/></td>
				<td><c:out value="${o.statusEnum.engName}"/></td>
				<td><c:out value="${o.paymentStatusEnum.engName}"/></td>
				<td><c:out value="${o.total}"/></td>
				<!-- TODO add more methods here -->
				<td><a href="">Change</a></td>
				<td><a href="">View</a></td>
			</tr>
		</c:forEach>

</table>