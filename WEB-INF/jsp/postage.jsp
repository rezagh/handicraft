<script src="js/jquery-1.3.2.js" type="text/javascript"></script>         
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="com.handicraft.model.ProductDO" %>

<head>
	<script type='text/javascript' src='dwr/interface/DwrFrontController.js'></script>
	<script type='text/javascript' src='dwr/engine.js'></script>
	<script type='text/javascript' src='dwr/util.js'></script>
	
	<script>
		function getRate()
		{
			var country = document.getElementById("country").value;
			if(country == '--') {
				alert ("Select Country.");
				document.getElementById('postalRate').value = '';
				return;
			}
			var quantity = document.getElementById("quantitySelected").value;
			var weightUnit = "${product.weightUnit}";// should be in the qoutes to work
			var weight = "${product.weight}";
			
			//String toCountry, int quantity, Double weight, String weightUnit
			DwrFrontController.getPostalRate(country,quantity,weight,weightUnit,function(ret) {
				document.getElementById('postalRate').value = ret;
			});
		}
	</script>
</head>

<div  style="padding: 1">
Calculate Postage:<br/>
		<table border="1">
			<tr>
				<td>
					Country:
					<%@ include file="country.jsp" %>
				</td>

				<td>
					Quantity:
					<select name="orderQuantity" id="quantitySelected">
						<%
							ProductDO product = (ProductDO)request.getSession().getAttribute("product");
							for(int i=1;i<=product.getQuantity();i++){
								%>
								<option value="<%=i%>"><%=i%></option>
								<%	
							}
						%>
					</select>
				</td>
				<td><input type="button"  value="Get Post Rate" onclick="javascript:getRate()"/></td>
				<td><input name="postalRate"  id="postalRate" disabled="disabled"/>
			</tr>
		</table>
</div>