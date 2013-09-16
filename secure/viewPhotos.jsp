<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:forEach items="${files}" var="file">
	<div style="float: left;border: 1px coral solid; padding: 3px">
	<img src="photoManager.htm?method=getImage&imageId=${file}" width="100" height="100"><br/>	
	<a href="photoManager.htm?method=getImage">${file}</a>
	<a href="photoManager.htm?method=deletePhoto&imageId=${file}">Delete</a>
	<a href="photoManager.htm?method=showEditPhoto&imageId=${file}">Edit</a>
	</div>
</c:forEach>
<br/>
<br/>


<a href="productManager.htm?method=showProductManager">Back</a>
