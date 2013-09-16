<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<form method="post" action="productManager.htm?method=addProduct">

<table>

	<tr>
		<td>name</td>
		<td><input name="name" id="name"></input></td>
	</tr>
	<tr>
		<td>code</td>
		<td><input name="code" id="code"></input>p1,p2,...lowercase</td>
	</tr>
	<tr>
		<td>price</td>
		<td><input name="price" id="price"	></input> USD</td>
	</tr>

	<tr>
		<td>category</td>
		<td>
			<select name="category.id" >
				<c:forEach var="c" items="${categories}">
					<option value="${c.id}"><c:out value="${c.name}"/></option>
				</c:forEach>	
			</select>
		</td>
	</tr>
	<tr>
		<td>description</td>
		<td><input name="description" id="description"></input></td>
	</tr>
	<tr>
		<td>weight</td>
		<td><input name="weight" id="weight"></input></td>
	</tr>
	<tr>
		<td>weightUnit</td>
		<td>
			<select name="weightUnit" >
				<c:forEach var="w" items="${weights}">
					<option value="<c:out value="${w}"/>"><c:out value="${w}"/></option>
				</c:forEach>	
			</select>
		</td>
	</tr>
	<tr>
		<td>quantity</td>
		<td><input name="quantity" id="quantity"></input>maybe limit this to 10?</td>
	</tr>
	<tr>
		<td>imageRef</td>
		<td>is productcode.jpg</td>
	</tr>

	<tr>
		<td>
		<input name="submit" type="submit" class="btn" value="Save" /> 
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