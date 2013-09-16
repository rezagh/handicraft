Hello, Please login here:

<form name="f" action="j_spring_security_check" method="POST">
	<table>
		<tr>
			<td>Email:</td>
			<td><input class="css" type='text' dir="ltr" name='j_username' '/></td>
		</tr>
	
		<tr>
			<td>Password:</td>
			<td><input class="css" type='password' dir="ltr"	name='j_password'></td>
		</tr>
	
		<tr>
			<td colspan='2'><input name="submit" type="submit" class="btn"	value="login"></td>
		</tr>
	</table>
	
	<input type="checkbox" style="visibility: hidden" checked="checked"	name="_spring_security_remember_me">
		
		
	<a href="redirect.htm?pageId=register">New User?</a>		
	<a href="redirect.htm?pageId=forgotPass">Forgot Password?</a>

</form>
