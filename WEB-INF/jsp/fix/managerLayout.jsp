<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!-- this the the page template -->


<head>
<title><tiles:getAsString name="title" /></title>
</head>

<div style="padding: 1">
	<tiles:insertAttribute name="header" />
</div>
<div>
	<div style="float: left; background-color: #669922;height: 500;padding: 1">
		<tiles:insertAttribute name="leftmenu" />
	</div>
	<div  style="float: left;padding-left: 5;padding-top: 5">
		<tiles:insertAttribute name="body" />
	</div>
</div>


<div style="clear:both" align="center">
	<tiles:insertAttribute name="footer" />
</div>