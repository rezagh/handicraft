<form method="post" action="productManager.htm?method=addCategory">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<table>

	<tr>
		<td>name</td>
		<td><input name="name"></input></td>
	</tr>
	<tr>
		<td>code</td>
		<td><input name="code"></input></td>
		<td>lowercase no space</td>
	</tr>
	<tr>
		<td>Parent</td>
		<td>
			<select name="parentCategory.id" >
				<option value="null">no parent</option>
				<c:forEach var="c" items="${categories}">
					<option value="<c:out value="${c.id}"/>"><c:out value="${c.name}"/></option>
				</c:forEach>	
			</select>
		
		</td>
	</tr>

	<tr>
		<td>shortDesc</td>
		<td><input name="shortDesc" id="shortDesc"></input></td>
	</tr>
	<tr>
		<td>longDesc</td>
		<td><input name="longDesc" id="longDesc"></input></td>
	</tr>

	<tr>
		<td>imageRef</td>
		<td>is categorycode.jpg</td>
	</tr>

	<tr>
		<td>
		<input name="submit" type="submit" class="btn" value="Add" /> 
		</td>
	</tr>
	<tr>
		<td>Result</td>
		 <td>
		<input name="result" value="${result}" disabled="disabled"/>
		</td>
	</tr>

</table>

</form>

<a href="productManager.htm?method=showProductManager">Back</a>