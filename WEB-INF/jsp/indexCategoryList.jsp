<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<p align="center">
	<b>This site is under active construction and it not selling anything now. <br/>
	Current products are just for testing purposes.<br/>
	Please contact us for questions. We are looking for handicraft sellers in Iran now.</b><br/>
</p>	
	<c:forEach var="c" items="${categories}">
		<div style="float: left; padding: 5">
			<a href="product.htm?method=getProductsByCategory&categoryId=${c.id}">
				<img alt="" src="photo.htm?method=getImage&imageId=${c.imageRef}" class="smallimage">
			</a><br/>
			<c:out value="${c.name}"/><br/>
			<c:out value="${c.shortDesc}"/>
			<br/>
			<a href="product.htm?method=getProductsByCategory&categoryId=${c.id}">more info...</a>
		</div>
	</c:forEach>
	

	<%@ include file="fix/googleAnalytics.jsp"%>
	
