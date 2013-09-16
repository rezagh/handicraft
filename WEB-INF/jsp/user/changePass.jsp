<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<link href="css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function submitme(){

	if(document.getElementById("newPassword").value ==
		document.getElementById("newPassword2").value){
			document.myform.submit();

		}else{

			alert("ding");

		}	  
}

</script>

<body>

	<form method="post" name="myform" action="user.htm?method=changePassword">
	
		<div align="center">
	
			<table>
				<tr>
					<td>Current Password:</td>
					<td><input  class="css"  dir="ltr" name="currentPassword"/></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><input class="css" id="newPassword" dir="ltr" name="newPassword"/></td>
				</tr>
				<tr>
					<td>Type It Again:</td>
					<td><input class="css" id="newPassword2"  dir="ltr" name="newPassword2"/></td>
				</tr>
				<tr>
					<td><input class="btn"   type="button" onclick="submitme()" value="Send"/></td>
				</tr>
			
			</table>
		</div>
	</form>


</body>

<c:out value="${result}"/>

</html>