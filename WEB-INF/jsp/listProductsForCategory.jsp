<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


Categories >> Products >> <br/> <br/>

		<c:forEach var="p" items="${products}">
			<div style="float: left; padding: 5">	
				<a href="product.htm?method=getProduct&productId=${p.id}">
					<img class="smallimage" alt="" src="photo.htm?method=getImage&imageId=${p.imageRef}"><br/>
				</a>
				<c:out value="${p.name}"/> <br/>
				$US <c:out value="${p.price}"/> <br/>
				<!--
					<c:out value="${p.category}"/><br/> 
				-->
				<a href="product.htm?method=getProduct&productId=${p.id}">more info...</a>
			</div>
		</c:forEach>
