<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<form action="photoManager.htm?method=renamePhoto" method="post">
	<input name="oldName" type="hidden" value="${oldName}">
	
	Old Name : ${oldName}	 <br/>
	Rename : <input type="text" name="newName"/>
	<input type="submit" value="Rename">
</form>

<a href="photoManager.htm?method=deletePhoto&imageId=${oldName}">Delete</a>

<br/>

<a href="photoManager.htm?method=showImages">Back</a>