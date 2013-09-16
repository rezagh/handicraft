<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

			<c:if test="${user != null}" >
				Hi <c:out value="${user.firstname}"/>  
			</c:if> 
<br/>
<br/>
<b>Categories</b><br/>

	<c:forEach var="c" items="${categories}">
		<a href="product.htm?method=getProductsByCategory&categoryId=${c.id}">${c.name}</a><br/>
	</c:forEach>
<br/>


