<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<link rel="icon" type="image/png" href="assets/images/omerai_title_logo.png" />

<title><tiles:insertAttribute name="title" ignore="true" /></title>

        <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="outer/css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="outer/font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="outer/css/animate.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="outer/css/creative.css" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     
    
</head>
<body>
	 <div class="page">
            <tiles:insertAttribute name="body" />
    </div>
       <!-- jQuery -->
    <script src="outer/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="outer/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="outer/js/jquery.easing.min.js"></script>
    <script src="outer/js/jquery.fittext.js"></script>
    <script src="outer/js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="outer/js/creative.js"></script>
</body>
</html>
