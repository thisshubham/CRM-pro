<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="assets/images/omerai_title_logo.png" />

<title><tiles:insertAttribute name="title" ignore="true" /></title>
 
    
    
</head>
<body>

        <tiles:insertAttribute name="header" />
		<table>
		<tr><td ><tiles:insertAttribute name="leftmenu" /></td>
		<td ><tiles:insertAttribute name="body" /></td></tr>
		</table>
        <tiles:insertAttribute name="footer" />



</body>
</html>
