<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<table border="1">
<tr>
	<td>name</td>
	<td>code</td>
	<td>price</td>
	<td>weight</td>
	<td>weightUnit</td>
	<td>category</td>
	<td>description</td>
	<td>quantity</td>
	
	<td>Action</td>
</tr>
		<c:forEach var="p" items="${products}">
			<tr>	
				<td><c:out value="${p.name}"/></td>
				<td><c:out value="${p.code}"/></td>
				<td><c:out value="${p.price}"/></td>
				<td><c:out value="${p.weight}"/></td>
				<td><c:out value="${p.weightUnit}"/></td>
				<td><c:out value="${p.category.name}"/></td>
				<td><c:out value="${p.description}"/></td>
				<td><c:out value="${p.quantity}"/></td>
				<td><a href="productManager.htm?method=removeProduct&productId=${p.id}">Delete</a></td>
			</tr>
		</c:forEach>

		</table>
		
		<a href="productManager.htm?method=showProductManager">Back</a>