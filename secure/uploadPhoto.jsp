<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<form method="post" action="photoManager.htm?method=upload" ENCTYPE="multipart/form-data">
	<input type="file" name= "uploadFile"> (Limit < 1 MB)<br/>
	New Name(with extension): <input type="text" name= "newName">(optional)<br/>
	<input type="submit" value="Upload">
</form>

Result: ${result} <br/>



<a href="photoManager.htm?method=showImages">Show Images</a>

