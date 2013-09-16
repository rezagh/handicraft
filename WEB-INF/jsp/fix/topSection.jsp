<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<table bgcolor="#669922" width="100%">
	<tr>
		<td valign="top">
			<a class="menu" href="front.htm">
				<img src="img/logo.jpg" width="150" height="68" alt="logo"></img>
			</a>
		</td>
		<td align="left" width="100%">
			<a class="menu" href="front.htm"><font color="#0732EA">Home Page</font></a> | 
			<a class="menu" href="inquiry.htm?method=listInquiryPage"><font color="#0732EA"> Contact Us</font></a> | 
			<a class="menu" href="cart.htm?method=showCart"><font color="#0732EA"> Shopping Cart</font></a> |

				<security:authorize ifAnyGranted="ROLE_USER">
				</security:authorize>


				<security:authorize ifAnyGranted="ROLE_USER,ROLE_SUPER_USER,ROLE_ADMIN">
					<a href="user.htm?method=showUserAccount">My Account</a> | 						
		  			<a href="<c:url value="/j_spring_security_logout"/>">Log Out</a> |
				</security:authorize>
 				
				<security:authorize ifNotGranted="ROLE_USER,ROLE_SUPER_USER,ROLE_ADMIN">
						<a class="menu" href="redirect.htm?pageId=login"><font color="#0732EA"> Login</font></a> | 
						<a class="menu" href="user.htm?method=showRegisterPage"><font color="#0732EA"> Register</font></a> |
				</security:authorize>

				<security:authorize ifAnyGranted="ROLE_SUPER_USER">
					<a href="productManager.htm?method=showProductManager">Manager</a> |						
				</security:authorize>

		</td>	
	</tr>
	<tr>
		<td>
		</td>
	</tr>
</table>

