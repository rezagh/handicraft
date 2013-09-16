<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<table border="1">
<tr>
	<td>name</td>
	<td>code</td>
	<td>parentCode</td>
	<td>shortDesc</td>
	<td>longDesc</td>
	
	<td>Action</td>
</tr>
		<c:forEach var="p" items="${categories}">
			<tr>	
				<td><c:out value="${p.name}"/></td>
				<td><c:out value="${p.code}"/></td>
				<td><c:out value="${p.parentCategory.code}"/></td>
				<td><c:out value="${p.shortDesc}"/></td>
				<td><c:out value="${p.longDesc}"/></td>
				<td><a href="productManager.htm?method=removeCategory&catId=${p.id}">Delete</a></td>
			</tr>
		</c:forEach>

		</table>
		
		When you delete a category, make sure there is no product in that category!
		
		<br/>
		<a href="productManager.htm?method=showProductManager">Back</a>