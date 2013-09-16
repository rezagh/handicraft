<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<form action="orderManager.htm?method=changeOrder" method="post">
	
	<input type="hidden" name="number" value="${order.number}"/>
	 
	<table border="1">
		<tr>
			<td>Order No.</td><td><c:out value="${order.number}"/></td>
		</tr>
		<tr>
			<td>Order Status</td>
			<td>
				<select name="status">
					<c:forEach items="${orderStatusValues}" var="status">
						<option value="${status}" ${order.status == status ? 'selected' : ''}>${status}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>Payment Status</td>
			<td>
				<select name="paymentStatus">
					<option value="">--</option>
					<c:forEach items="${paymentStatusValues}" var="paymentStatus">
						<option value="${paymentStatus}" ${order.paymentStatus == paymentStatus ? 'selected' : ''}>${paymentStatus}</option>
					</c:forEach>
				</select>
				
			</td>
		</tr>
	</table>
	<input value="Change" type="submit"/> 
</form>
<a href="orderManager.htm?method=showActiveOrders">Cancel</a>