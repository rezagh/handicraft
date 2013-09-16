<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<head></head>
<body>

	<form method="post" name="userController" action="user.htm?method=forgotPassword">
		<table>
			<tr>
				<td>Email: </td>
				<td><input  class="css"  dir="ltr" name="email"/></td>
			</tr>
		
		</table>
		
		<input name="submit"  type="submit"  class="btn" value="Email me my password"/>
	</form>

<c:out value="${result}"/><br/>

<a href="redirect.htm?pageId=login">Login Here</a>

</body>
</html>