<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">


<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div class="page">
		
			<tiles:insertAttribute name="header" />
			
				<tiles:insertAttribute name="body" />
		
			<tiles:insertAttribute name="footer" />
		
	</div>
	<!-- jQuery 2.1.1 -->
<script src="inner/assets/lib/jquery/jquery.min.js"></script>
	
	<!-- <script type="text/javascript">
function logoutUser(){
window.location.replace("customerLogout.action");
}
</script> -->
</body>
</html>
