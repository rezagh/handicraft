<%@ page import="com.handicraft.vo.CartVO" %>
<%@ page import="com.handicraft.util.Codes" %>
<%@ page import="java.util.List" %>
<%@ page import="com.handicraft.model.type.CountryEnum" %>
<%@ page import="com.handicraft.model.UserDO"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

	<select name="country" id="country">
		<option value="--">--</option>
		
			<%
				List<CountryEnum> countries = (List<CountryEnum>)request.getSession().getAttribute(Codes.COUNTRIES);
				CartVO cart = (CartVO)request.getSession().getAttribute(Codes.VAR_CART);
				UserDO user = (UserDO)request.getSession().getAttribute("user");
				
				String orderCountry = ""; 
				
				if(cart != null)
					orderCountry = cart.getOrderCountry();
				
				if(user != null)
					orderCountry = user.getCountry();

				for(CountryEnum country : countries){
					if(country.name().equals(orderCountry)){
					%>
						<option selected="selected" value="<c:out value="<%=country%>"/>"><c:out value="<%=country%>"/></option>
					<%					
					}else{
					%>
						<option value="<c:out value="<%=country%>"/>"><c:out value="<%=country%>"/></option>
					<%
					
					}
				}
				%>
					
	</select>
