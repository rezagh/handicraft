<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>

<html>
<link href="css/main.css" rel="stylesheet" type="text/css" />

	<form:form method="post" name="inquiryController" action="inquiry.htm?method=sendInquiry">
		<table>
			<tr>
				<td>*Subject: </td>
				<td>
					<select name="type" class="css">
						<c:forEach var="e" items="${inquiryTypes}">
							<option value="<c:out value="${e}"/>"><c:out value="${e.engValue}"/></option>
						</c:forEach>	
					</select>
				</td>
			</tr>
				<security:authorize ifAnyGranted="ROLE_USER">
				</security:authorize>
 				
				<security:authorize ifNotGranted="ROLE_USER">
					<tr>
						<td>*Email: </td>
						<td><input name="email"/><form:errors  path="email"/></td>
					</tr>
				</security:authorize>

			<tr>
				
				<td>*Message: </td>
				<td>
					<textarea rows="6" cols="23" class="css" name="message"></textarea><form:errors  path="message"/>			
				</td>
			</tr>
		
			<tr>
				<td><input name="submit"  type="submit" class="btn" value="Send"/></td>
			</tr>
		</table>
	</form:form>

* field mandatory